package com.smile.graaldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GraalDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraalDemoApplication.class, args);
    }

    @RestController
    static class SimpleController {
        @GetMapping("/simple")
        public ResponseEntity<String> simple() {
            return ResponseEntity.ok("success");
        }
    }
}
