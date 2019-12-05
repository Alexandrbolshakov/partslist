package ru.example.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.example.voting.domain.User;
import ru.example.voting.domain.UserRole;
import ru.example.voting.repo.UserRepo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", UserRole.values());
        return "userEdit";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveUser(
            @RequestParam("userId") User user,
            @RequestParam Map<String, String> form,
            @RequestParam String username
            ){
        user.setUsername(username);
        Set<String> roles = Arrays.stream(UserRole.values())
                .map(UserRole::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for(String key: form.keySet()){
            if(roles.contains(key)){
                user.getRoles().add(UserRole.valueOf(key));
            }
        }
        userRepo.save(user);
        return "redirect:/user";
    }
    @GetMapping("/userList")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userList(Map<String,Object>model){
        Iterable<User>users = userRepo.findAll();
        model.put("users", users);
        return "userList";
    }

    @PostMapping("/userList")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addUser(Map<String,Object>model,
                          @RequestParam String name,
                          @RequestParam String password){
        if(name==null||name.equals("")){
            model.put("message", "Введите имя");
            return "userList";
        }
        if(password==null||password.equals("")){
            model.put("message", "Введите пароль");
            return "userList";
        }
        User user = new User(name, password, Collections.singleton(UserRole.USER));
        userRepo.save(user);
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);
        return "userList";
    }
}
