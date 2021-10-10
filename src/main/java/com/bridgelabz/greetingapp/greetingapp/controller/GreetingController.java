package com.bridgelabz.greetingapp.greetingapp.controller;

import com.bridgelabz.greetingapp.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/message")
    public String getMessage() {
        return greetingService.getMessage();
    }
}
