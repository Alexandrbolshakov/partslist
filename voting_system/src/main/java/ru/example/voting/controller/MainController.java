package ru.example.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.example.voting.domain.Restaurant;
import ru.example.voting.repo.MenuRepo;
import ru.example.voting.repo.RestaurantRepo;

import java.util.Map;


@Controller
public class MainController {
    @Autowired
    RestaurantRepo restaurantRepo;

    @Autowired
    MenuRepo menuRepo;

    @GetMapping("/start")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String,Object> model) {
        model.put("name", name);
        return "start";
    }

    @GetMapping("/")
    public String restaurantList(Map<String,Object> model){
        model.put("restaurants", restaurantRepo.findAll());
        return "main";
    }
    @PostMapping("/")
    public String add(@RequestParam String name, @RequestParam Double rating, Map<String,Object> model){
        Restaurant restaurant=new Restaurant(rating, name);
        restaurantRepo.save(restaurant);
        model.put("restaurants", restaurantRepo.findAll());

        return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String,Object>model){
//        List<Menu> lists = menuRepo.findByRestaurant(restaurant);
//        model.put("dishes", lists);
        return "main";
    }
}
