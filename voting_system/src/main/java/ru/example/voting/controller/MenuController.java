package ru.example.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.example.voting.domain.Menu;
import ru.example.voting.repo.MenuRepo;

import java.util.Map;

@Controller
public class MenuController {
    @Autowired
    MenuRepo menuRepo;

//    @GetMapping("/mealList")
//    public String mealList(Map<String,Object>model){
//        model.put("dishes", menuRepo.findAll());
//        return "mealList";
//    }
//
//    @PostMapping("/mealList")
//    public String add(
//            @RequestParam String name,
//            @RequestParam Double price,
//            Map<String,Object> model){
//        Menu menu = new Menu(price,name);
//        menuRepo.save(menu);
//        model.put("dishes", menuRepo.findAll());
//        return "mealList";
//    }



}
