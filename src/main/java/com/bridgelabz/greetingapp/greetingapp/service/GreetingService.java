package com.bridgelabz.greetingapp.greetingapp.service;

import com.bridgelabz.greetingapp.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public String findGreetingById(int id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        if (greeting.isPresent()) {
            return "The Greeting record with id is found: " + id;
        }
        return "Cannot find greeting record with given id: " + id;
    }

    public String editGreeting(int id, GreetingDTO greetingDTO) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        if (greeting.isPresent()) {
            Greeting greeting1 = greeting.get();
            greeting1.setMessage(greetingDTO.getMessage());
        }
        return "Cannot find greeting record with given id: " + id;
    }

    public String deleteGreeting(int id) {
        Optional<Greeting> studentEntity = greetingRepository.findById(id);
        if (studentEntity.isPresent()) {
            greetingRepository.delete(studentEntity.get());
            return "Record deleted successfully";
        }
        return "Record does not exists with this id : " + id;
    }
}

