package com.facimath.facimath.service;

import com.facimath.facimath.dto.TestCreateDto;
import com.facimath.facimath.entity.Test;
import com.facimath.facimath.entity.User;
import com.facimath.facimath.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestRepository repository;

    public TestService(TestRepository repository) {
        this.repository = repository;
    }

    public List<Test> getAllTest(User user) {
        return repository.getAllByUser(user.getId());
    }

    public List<Test> getAllNotFinish(User user) {
        return repository.getAllNotFinishByUser(user.getId());
    }

    public Test add(TestCreateDto dto, long id){
        User user = new User();
        user.setId(id);

        Test test = new Test();
        test.setTest(dto.getText());
        test.setStatus(dto.isStatus());
        test.setUser(user);

        return repository.save(test);
    }
}
