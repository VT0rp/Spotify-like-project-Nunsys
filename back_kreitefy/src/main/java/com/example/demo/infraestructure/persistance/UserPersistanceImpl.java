package com.example.demo.infraestructure.persistance;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.persistance.UserPersistance;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserPersistanceImpl implements UserPersistance {

    private final com.example.demo.infraestructure.persistance.UserJpaRepository userJpaRepository;

    public UserPersistanceImpl(com.example.demo.infraestructure.persistance.UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override public User save(User user) {
        return userJpaRepository.save(user);
    }

    @Override public Optional<User> find(String username) {
        return userJpaRepository.findById(username);
    }

}
