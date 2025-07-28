package com.practice.core.endpoint;

import com.practice.core.domain.Test;
import com.practice.core.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestEndpoint {

    private final TestService testService;

    public TestEndpoint(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestParam(name = "request", required = false) String request) {
        testService.save(request);
        return ResponseEntity.ok("Ok".concat(request));
    }

    @GetMapping("/test/list")
    public ResponseEntity<List<Test>> test1() {
        return ResponseEntity.ok(testService.list());
    }
}
