package ru.example.voting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.example.voting.domain.Menu;
import ru.example.voting.domain.Restaurant;

import java.util.List;

public interface MenuRepo extends CrudRepository<Menu,Long> {
    List<Menu> findByRestaurant(Restaurant restaurant);
}
