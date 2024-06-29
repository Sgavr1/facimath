package com.facimath.facimath.mapper;

import com.facimath.facimath.dto.UserCreateDto;
import com.facimath.facimath.dto.UserDto;
import com.facimath.facimath.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserDto dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setLogin(dto.getLogin());

        return entity;
    }

    public User toEntity(UserCreateDto dto) {
        User entity = new User();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setLogin(dto.getLogin());
        entity.setPassword(dto.getPassword());

        return entity;
    }

    public UserDto toDto(User entity) {
        return new UserDto(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getLogin());
    }
}
