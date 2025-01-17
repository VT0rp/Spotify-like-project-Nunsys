package com.example.demo.application.service;

import com.example.demo.application.dto.UserDto;

import java.util.Optional;

public interface UserService {
    Optional<UserDto> getUser(String username);
}
