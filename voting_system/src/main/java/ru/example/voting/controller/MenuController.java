package ru.example.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.example.voting.domain.Menu;
import ru.example.voting.domain.Restaurant;
import ru.example.voting.repo.MenuRepo;
import ru.example.voting.repo.RestaurantRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class MenuController {
    @Autowired
    MenuRepo menuRepo;

    @Autowired
    RestaurantRepo restaurantRepo;

    @GetMapping("/add")
    public String addPage(){
        return "add";
    }


    @GetMapping("/add_meal/{id}")
    public String mealList(Map<String, Object> model, @PathVariable("id") String id){
        Long idL = Long.parseLong(id);

        Iterable<Menu> dishes = menuRepo.findByRestaurant(restaurantRepo.findById(idL).get());

        model.put("dishes", dishes);
        return "add_meal";
    }


    @PostMapping("/add_meal/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
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

        Menu menu = new Menu(price,name, LocalDate.now(),restaurant);

        menuRepo.save(menu);
        Iterable<Menu> dishes = menuRepo.findByRestaurant(restaurant);
        model.put("dishes", dishes);

        return "add_meal";

    }

    @GetMapping("/deleteDish/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteDish(Map<String,Object>model, @PathVariable Long id){
        menuRepo.deleteById(id);
        Iterable<Menu> dishes = menuRepo.findAll();
        model.put("dishes", dishes);
        return "mealList";
    }

    @GetMapping("/mealList")
    public String mealList(@RequestParam(required = false, defaultValue = "")String filter, Model model){
        Iterable<Menu> dishes;
        if(filter!=null&&!filter.equals("")){
            dishes = menuRepo.findByRestaurant(restaurantRepo.findByName(filter).get(0));
        }else {
            dishes = menuRepo.findAll();
        }

        model.addAttribute("dishes", dishes);
        model.addAttribute("filter", filter);
        return "mealList";
    }




}
