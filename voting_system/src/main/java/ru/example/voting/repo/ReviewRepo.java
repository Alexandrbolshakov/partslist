package ru.example.voting.repo;

import org.springframework.data.repository.CrudRepository;
import ru.example.voting.domain.Review;

public interface ReviewRepo extends CrudRepository<Review, Long> {
}
