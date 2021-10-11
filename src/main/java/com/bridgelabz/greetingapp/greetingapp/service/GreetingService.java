package com.bridgelabz.greetingapp.greetingapp.service;

import com.bridgelabz.greetingapp.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Layer contains business logic,
 * It implements all the methods in controller layer
 * @author - Sakshi Shetty
 * @version - 0.0.1
 * @since - 10/10/2021
 */

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    /**
     * Function to get the list of greetings stored in database
     * @return list of greetings
     */
    public List<Greeting> messages() {
        return greetingRepository.findAll();
    }

    public String getMessage() {
        return "Hello World!";
    }

    /**
     * Function to add greetings and save greetings to the database
     * @param greetingDto greeting data from client
     * @return greeting messages created
     */
    public Greeting saveMessage(GreetingDTO greetingDto){
        Greeting greeting = new Greeting();
        greeting.setMessage(greetingDto.getMessage());
        return greetingRepository.save(greeting);
    }

    /**
     * Function to get a particular greeting stored in database
     * @param id unique id of the greeting message
     * @return greeting with the unique id
     */

    public Greeting findGreetingById(int id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        if (greeting.isPresent()) {
            return greeting.get();
        }
        return null;
    }

    /**
     * Function to edit the available greeting in the database
     * @param id unique id of the greeting
     * @param greetingDTO greeting data from client
     * @return updated greeting message
     */
    public Greeting editGreeting(int id, GreetingDTO greetingDTO) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        if (greeting.isPresent()) {
            Greeting greeting1 = greeting.get();
            greeting1.setMessage(greetingDTO.getMessage());
            return greeting1;

        }
        return null;
    }

    /**
     * Function to particular greeting message from database and delete it
     * @param id unique id of the greeting
     * @return String message displaying status of operation
     */
    public String deleteGreeting(int id) {
        Optional<Greeting> greetingMessage = greetingRepository.findById(id);
        if (greetingMessage.isPresent()) {
            greetingRepository.delete(greetingMessage.get());
            return "Record deleted successfully";
        }
        return "Record does not exists with this id : " + id;
    }
}

