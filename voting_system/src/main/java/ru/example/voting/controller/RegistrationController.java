package ru.example.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.example.voting.domain.User;
import ru.example.voting.domain.UserRole;
import ru.example.voting.repo.UserRepo;

import javax.swing.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @RequestParam String name,
            @RequestParam String password,
            @RequestParam String role,
            Map<String,Object> model){
       User userFromDB= userRepo.findByUsername(name);
       Set<UserRole> roles;
       if(userFromDB!=null){
           roles=userFromDB.getRoles();
           UserRole r = UserRole.valueOf(role);
           roles.add(r);
           userFromDB.setRoles(roles);
           model.put("message", "user exists");
           return "registration";
       }
       User user = new User();
       user.setUsername(name);
       user.setPassword(password);

       user.setRoles(Collections.singleton(UserRole.valueOf(role)));
       user.setActive(true);
       userRepo.save(user);
        return "redirect:/login";
    }
}
