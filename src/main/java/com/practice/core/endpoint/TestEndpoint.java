package com.practice.core.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEndpoint {

    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestParam(name = "test", required = false) String test) {
        return ResponseEntity.ok("Ok".concat(test));
    }

    @GetMapping("/test1")
    public ResponseEntity<String> test1(@RequestParam(name = "test", required = false) String test) {
        return ResponseEntity.ok("Ok".concat(test));
    }
}
