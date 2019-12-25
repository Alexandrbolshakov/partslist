package com.example.sells.controller;

import com.example.sells.domain.Role;
import com.example.sells.domain.User;
import com.example.sells.repos.UserRepo;
import com.example.sells.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("registration")
    public String addUser(
            @RequestParam("password2") String passwordConfirmation,
            User user,
            Map<String, Object> model){

        if(user.getPassword()!=null&&!user.getPassword().equals(passwordConfirmation)){
            model.put("message", "пароли не совпадают");
            return "registration";
        }

        if(!userService.addUser(user)){
            model.put("message", "Такой пользователь уже существует");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivated = userService.activateUser(code);

        if(isActivated){
            model.addAttribute("message", "User successfully activated");
        }else{
            model.addAttribute("message", "activation code is not found");
        }
        return "login";
    }
}
