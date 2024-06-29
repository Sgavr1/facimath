package com.facimath.facimath.service;

import com.facimath.facimath.dto.UserCreateDto;
import com.facimath.facimath.dto.UserDto;
import com.facimath.facimath.entity.User;
import com.facimath.facimath.mapper.UserMapper;
import com.facimath.facimath.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserDto authorization(String login, String password) throws RuntimeException {
        Optional<User> user = repository.findByLoginAndPassword(login, password);
        if (user.isPresent()) {
            return mapper.toDto(user.get());
        } else {
            throw new RuntimeException("User not found login: " + login + " password: " + password);
        }
    }

    public UserDto registration(UserCreateDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());

        user = repository.save(user);

        return mapper.toDto(user);
    }
}