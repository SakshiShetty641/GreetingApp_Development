package com.bridgelabz.greetingapp.greetingapp.controller;

import com.bridgelabz.greetingapp.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Layer that receives various HTTP request from client
 * @author - Sakshi Shetty
 * @version - 0.0.1
 * @since - 10/10/2021
 */

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    /**
     * Function to get mapping from client
     * @return greeting
     */
    @GetMapping(value = "/messages")
    public List<Greeting> messages() {
        return greetingService.messages();
    }

    /**
     * Function to get mapping from client
     * @return greeting
     */
    @GetMapping("/message")
    public String getMessage() {
        return greetingService.getMessage();
    }

    /**
     * Function to get mapping from client
     * @return greeting
     */
    @GetMapping("/message/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello " + name ;
    }

    /**
     * Function to get mapping from client
     * @return greeting with first name and last name
     */
    @GetMapping("/getmessage")
    public String greeting(@RequestParam String firstName, @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    /**
     * Function to receive get request from client
     * @param greetingDto greeting data from client
     * @return added greetings in the database
     */
    @PostMapping("/savegreeting")
    public Greeting saveGreeting(@RequestBody GreetingDTO greetingDto){
        return greetingService.saveMessage(greetingDto);
    }

    /**
     * Function to post request from client
     * @param id unique id of the greeting
     * @return greeting message with the unique id
     */
    @GetMapping("/findbyid/{id}")
    public Greeting findGreetingById(@PathVariable int id){
        return greetingService.findGreetingById(id);
    }

    /**
     * Function to receive put request from client
     * @param id unique id of the greeting
     * @return updated greeting message
     */
    @PutMapping(value = "/editgreeting/{id}")
    public Greeting editGreeting(@PathVariable int id, @RequestBody GreetingDTO greetingDto){
        return greetingService.editGreeting(id, greetingDto);
    }

    /**
     * Function to delete greeting from client
     * @param id unique id of the greeting
     * @return String message displaying status of operation
     */
    @DeleteMapping(value = "/deletegreeting")
    public String deleteGreeting(@RequestParam int id) {
        return greetingService.deleteGreeting(id);
    }
}
