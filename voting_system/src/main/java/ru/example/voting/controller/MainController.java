package ru.example.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.example.voting.domain.Menu;
import ru.example.voting.domain.Restaurant;
import ru.example.voting.repo.MenuRepo;
import ru.example.voting.repo.RestaurantRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Controller
public class MainController {
    @Autowired
    RestaurantRepo restaurantRepo;

    @Autowired
    MenuRepo menuRepo;

    @GetMapping("/")
    public String startPage(Map<String,Object> model){
        model.put("message", "Hi");
        return "start";
    }

    @GetMapping("/restaurantList")
    public String restaurantList(Map<String,Object>model){
        Iterable<Restaurant> restaurants = restaurantRepo.findAll();
        model.put("restaurants", restaurants);
        return "restaurantList";
    }

    @GetMapping("/delete/{id}")
    public String deleteRest(Map<String, Object> model, @PathVariable Long id){
        restaurantRepo.deleteById(id);
        Iterable<Restaurant> restaurants = restaurantRepo.findAll();
        model.put("restaurants", restaurants);
        return "redirect:/restaurantList";
    }
    @PostMapping("/add")
    public String addRest(
            Map<String,Object>model,
            @RequestParam String name,
            @RequestParam Double rating) {
        List<Restaurant> restFromDB = restaurantRepo.findByName(name);
        if (name == null || name.equals("")) {
            model.put("message", "введите название ресторана");
            return "add";
        }
        if(restFromDB.size()!=0){
            model.put("message", "такой ресторан уже существует");
            return "add";
        }
        Restaurant restaurant = new Restaurant(rating, name);
        restaurantRepo.save(restaurant);
        Iterable<Restaurant> restaurants = restaurantRepo.findAll();
        model.put("restaurants", restaurants);

        return "redirect:/restaurantList";
    }

    @GetMapping("/votingList")
    public String votingList(Map<String,Object> model){
        return "votingList";
    }

    @GetMapping("/add")
    public String addPage(){
        return "add";
    }


    @GetMapping("/add_meal/{id}")
    public String mealList(Map<String, Object> model,  @PathVariable("id") String id){
        Long idL = Long.parseLong(id);

        Iterable<Menu> dishes = menuRepo.findByRestaurant(restaurantRepo.findById(idL).get());

        model.put("dishes", dishes);
        return "add_meal";
    }


    @PostMapping("/add_meal/{id}")
    public String addMeals(Map<String,Object> model,
                           @RequestParam String name,
                           @RequestParam Double price,
                           @PathVariable("id") String id){
        Long idL = Long.parseLong(id);
        Restaurant restaurant = restaurantRepo.findById(idL).get();
        List<Menu> menuFromDB = menuRepo.findByRestaurant(restaurant);
           if (name == null || name.equals("")) {
            model.put("message", "введите название ресторана");
            return "add_meal";
        }
        if (price == null || price<0) {
            model.put("message", "введите правильную цену блюда");
            return "add_meal";
        }
        for(Menu m:menuFromDB) {
            if (name.equals(m.getName())) {
                model.put("message", "такое блюдо уже существует");
                return "add_meal";
            }
        }

        Menu menu = new Menu(price,name,LocalDate.now(),restaurantRepo.findById(idL).get());

        menuRepo.save(menu);
        Iterable<Menu> dishes = menuRepo.findAll();
        model.put("dishes", dishes);

        return "add_meal";

    }

    @GetMapping("/deleteDish/{id}")
    public String deleteDish(Map<String,Object>model, @PathVariable Long id){
        menuRepo.deleteById(id);
        Iterable<Menu> dishes = menuRepo.findAll();
        model.put("dishes", dishes);
        return "mealList";
    }


}
