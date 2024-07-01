package com.facimath.facimath.service;

import com.facimath.facimath.dto.TestCreateDto;
import com.facimath.facimath.dto.TestDto;
import com.facimath.facimath.dto.UserDto;
import com.facimath.facimath.entity.Test;
import com.facimath.facimath.entity.User;
import com.facimath.facimath.mapper.TestMapper;
import com.facimath.facimath.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {
    private final TestRepository repository;
    private final TestMapper mapper;

    public TestService(TestRepository repository, TestMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<TestDto> getAllTest(UserDto user) {
        return repository.getAllByUser(user.getId()).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public TestDto add(TestCreateDto dto, long id){
        User user = new User();
        user.setId(id);

        Test test = mapper.toEntity(dto);
        test.setUser(user);

        return mapper.toDto(repository.save(test));
    }
}
