package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class first_spring_controller {
    @RequestMapping("/")
    public String sayHello() {
        return "Hello Ayanendu";
    }
}
