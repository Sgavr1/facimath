package com.facimath.facimath.controller;

import com.facimath.facimath.dto.TestCreateDto;
import com.facimath.facimath.entity.Test;
import com.facimath.facimath.service.TestService;
import com.facimath.facimath.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/tests")
    public ResponseEntity<List<Test>> getHistory(@RequestHeader("Authorization") String authorization) {
        if (authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);
            if (tokenService.validate(token)) {
                return ResponseEntity.ok(testService.getAllTest(tokenService.getUser(token)));
            }
        }

        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/not/finish/tests")
    public ResponseEntity<List<Test>> getAllNotFinisTest(@RequestHeader("Authorization") String authorization) {
        if (authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);
            if (tokenService.validate(token)) {
                return ResponseEntity.ok(testService.getAllNotFinish(tokenService.getUser(token)));
            }
        }

        return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/add/test")
    public ResponseEntity<Test> addTest(@RequestHeader("Authorization") String authorization, @RequestBody TestCreateDto test){
        if (authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);
            if (tokenService.validate(token)) {
                long id = tokenService.getUser(token).getId();
                return ResponseEntity.ok(testService.add(test, id));
            }
        }

        return ResponseEntity.badRequest().body(null);
    }
}