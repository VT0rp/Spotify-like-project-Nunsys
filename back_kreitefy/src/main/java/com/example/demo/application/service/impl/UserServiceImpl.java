package com.example.demo.application.service.impl;

import com.example.demo.application.dto.UserDto;
import com.example.demo.application.mapper.UserMapper;
import com.example.demo.application.service.UserService;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.persistance.UserPersistance;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserPersistance userPersistance;
    private final UserMapper userMapper;

    public UserServiceImpl(UserPersistance userPersistance, UserMapper userMapper){
        this.userPersistance = userPersistance;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<UserDto> getUser(String username){
        Optional<User> user = userPersistance.find(username);
        if(user.isPresent()){
            return Optional.of(userMapper.toDto(user.get()));
        }else{
            return Optional.empty();
        }
    }
}
