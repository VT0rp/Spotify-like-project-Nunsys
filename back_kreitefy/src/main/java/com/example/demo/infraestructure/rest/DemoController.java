package com.example.demo.infraestructure.rest;

import com.example.demo.application.service.UserService;
import com.example.demo.domain.entity.Song;
import com.example.demo.infraestructure.rest.auth.JwtService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

    private final JwtService jwtService;
    private final UserService userService;

    public DemoController(JwtService jwtService, UserService userService){
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @GetMapping("/user")
    public Map<String, String> getUserName(@RequestHeader("Authorization") String bearerToken){
        if( StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            String token = bearerToken.substring(7);
            String username = jwtService.getUsernameFromToken(token);
            Map<String, String> response = new HashMap<>();
            response.put("username", username);
            return response;
        }
        return null;
    }

}