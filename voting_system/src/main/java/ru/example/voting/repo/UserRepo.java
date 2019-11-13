package ru.example.voting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.example.voting.domain.User;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
