package ru.example.voting.repo;

import org.springframework.data.repository.CrudRepository;
import ru.example.voting.domain.Restaurant;

public interface RestaurantRepo extends CrudRepository<Restaurant,Long> {
}
