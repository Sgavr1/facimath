package com.facimath.facimath.controller;

import com.facimath.facimath.dto.JwtResponse;
import com.facimath.facimath.dto.UserDto;
import com.facimath.facimath.service.TokenService;
import com.facimath.facimath.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @CrossOrigin(origins = "http://localhost:4200/login")
    @GetMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestParam(name = "login") String login, @RequestParam(name = "password") String password) {
        try {
            UserDto user = userService.authorization(login, password);

            String token = tokenService.generation(user);

            return ResponseEntity.ok(new JwtResponse(token, user));
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}