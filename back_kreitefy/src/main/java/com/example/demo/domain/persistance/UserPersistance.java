package com.example.demo.domain.persistance;

import com.example.demo.domain.entity.User;

import java.util.Optional;

public interface UserPersistance {
    User save(User user);
    Optional<User> find(String username);
}
