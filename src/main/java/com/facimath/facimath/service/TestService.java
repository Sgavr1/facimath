package com.facimath.facimath.service;

import com.facimath.facimath.repository.TestRepository;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private final TestRepository repository;

    public TestService(TestRepository repository) {
        this.repository = repository;
    }
}
