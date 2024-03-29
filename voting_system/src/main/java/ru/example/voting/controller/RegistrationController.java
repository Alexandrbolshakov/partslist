package ru.example.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.example.voting.domain.User;
import ru.example.voting.domain.UserRole;
import ru.example.voting.repo.UserRepo;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object> model){
       User userFromDB= userRepo.findByUsername(user.getUsername());

       if(userFromDB!=null){
           model.put("message", "user exists!");
           return "registration";
       }
       user.setActive(true);
       user.setRoles(Collections.singleton(UserRole.USER));
       userRepo.save(user);
       return "redirect:/login";
    }
}
