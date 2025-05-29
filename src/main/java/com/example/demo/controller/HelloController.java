// File: HelloController.java
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.HelloDto;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/test")
    public String test() {
        return "Hello insomnia, you're working too hard.";
    }
    
    @PostMapping("/echo")
    public String echoData(@RequestBody HelloDto dto) {
        return "你送來了: " + dto.getMessage();
    }
}