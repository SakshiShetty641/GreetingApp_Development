package com.bridgelabz.greetingapp.greetingapp.controller;

import com.bridgelabz.greetingapp.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    
    @GetMapping("/message")
    public String getMessage() {
        return greetingService.getMessage();
    }

    @GetMapping("/message/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello " + name ;
    }

    @GetMapping("/getmessage")
    public String greeting(@RequestParam String firstName, @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    @PostMapping("/greetingMessage")
    public Greeting saveGreeting(@RequestBody GreetingDTO greetingDto){
        return greetingService.saveMessage(greetingDto);
    }

}
