package com.facimath.facimath.service;

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
}
