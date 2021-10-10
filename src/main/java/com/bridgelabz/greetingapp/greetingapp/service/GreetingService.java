package com.bridgelabz.greetingapp.greetingapp.service;

import com.bridgelabz.greetingapp.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public List<Greeting> messages() {
        return greetingRepository.findAll();
    }

    public String getMessage() {
        return "Hello World!";
    }

    public Greeting saveMessage(GreetingDTO greetingDto){
        Greeting greeting = new Greeting();
        greeting.setMessage(greetingDto.getMessage());
        return greetingRepository.save(greeting);
    }


}
