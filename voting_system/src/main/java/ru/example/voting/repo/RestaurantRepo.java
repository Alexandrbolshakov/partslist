package ru.example.voting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.voting.domain.Restaurant;

import java.util.List;

public interface RestaurantRepo extends JpaRepository<Restaurant,Long> {
    List<Restaurant> findByName(String name);
}
