package ru.example.voting.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
//
//    private Restaurant restaurant;

    private Integer scope;

    private LocalDateTime dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Review(User user, Integer scope, LocalDateTime dateTime) {
        this.user = user;
        this.scope = scope;
        this.dateTime = dateTime;
    }

    public Review() {
    }
    //
//    public Restaurant getRestaurant() {
//        return restaurant;
//    }
//
//    public void setRestaurant(Restaurant restaurant) {
//        this.restaurant = restaurant;
//    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
