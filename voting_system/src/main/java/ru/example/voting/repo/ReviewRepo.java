package ru.example.voting.repo;

import org.springframework.data.repository.CrudRepository;
import ru.example.voting.domain.Restaurant;
import ru.example.voting.domain.Review;
import ru.example.voting.domain.User;

import java.util.List;

public interface ReviewRepo extends CrudRepository<Review, Long> {
    List<Review> findByRestaurant(Restaurant restaurant);
    List<Review> findByUserAndRestaurant(User user, Restaurant restaurant);
}
