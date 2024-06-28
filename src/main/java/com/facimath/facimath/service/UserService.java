package com.facimath.facimath.service;

import com.facimath.facimath.dto.UserCreateDto;
import com.facimath.facimath.entity.User;
import com.facimath.facimath.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User authorization(String login, String password) {
        Optional<User> user = repository.findByLoginAndPassword(login, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("User not found login: " + login + " password: " + password);
        }
    }

    public User registration(UserCreateDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());

        user = repository.save(user);

        return user;
    }
}