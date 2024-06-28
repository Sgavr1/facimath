package com.facimath.facimath.controller;

import com.facimath.facimath.dto.JwtResponse;
import com.facimath.facimath.dto.UserCreateDto;
import com.facimath.facimath.entity.User;
import com.facimath.facimath.service.TokenService;
import com.facimath.facimath.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/registration")
    public ResponseEntity<JwtResponse> registration(@RequestBody UserCreateDto userCreate) {
        try {
            User user = userService.registration(userCreate);
            String token = tokenService.generation(user);

            return ResponseEntity.ok(new JwtResponse(token, user));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
}
