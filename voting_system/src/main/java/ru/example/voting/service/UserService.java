package ru.example.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.voting.repo.UserRepo;

@Service
public class UserService  {

    @Autowired
    UserRepo userRepo;

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return userRepo.findByUsername(s);
//    }
}
