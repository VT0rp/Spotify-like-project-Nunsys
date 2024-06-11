package com.example.demo.application.service.impl;

import com.example.demo.application.mapper.UserMapper;
import com.example.demo.application.service.AuthService;
import com.example.demo.application.dto.UserDto;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.persistance.UserPersistance;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserPersistance userPersistence;
    private final UserMapper userMapper;

    public AuthServiceImpl(UserPersistance userPersistence, UserMapper userMapper) {
        this.userPersistence = userPersistence;
        this.userMapper = userMapper;
    }

    public UserDto register(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userPersistence.save(user));
    }

    @Override public Optional<UserDto> getUser(String username) {
        Optional<User> user = userPersistence.find(username);
        if (user.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(userMapper.toDto(user.get()));
    }
}
