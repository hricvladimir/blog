package com.vladimirhric.blog.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Yo from api");
    }

    @GetMapping("/goodbye")
    public ResponseEntity<String> goodbye() {
        return ResponseEntity.ok("goodbye");
    }

}
