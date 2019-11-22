package ru.example.voting.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rest")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double rating;

    private String name;

    @OneToMany
    private List<Menu> dishes;

    public Restaurant(Double rating, String name) {
        this.rating = rating;
        this.name = name;
    }

    public Restaurant() {
    }

    public List<Menu> getDishes() {
        return dishes;
    }

    public void setDishes(List<Menu> dishes) {
        this.dishes = dishes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
