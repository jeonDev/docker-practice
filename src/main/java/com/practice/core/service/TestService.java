package com.practice.core.service;

import com.practice.core.domain.Test;
import com.practice.core.domain.TestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Transactional
    public void save(String name) {
        testRepository.save(Test.of(name));
    }

    @Transactional(readOnly = true)
    public List<Test> list() {
        return testRepository.findAll();
    }
}
