package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    //Method to show and add data in database simultaneously
    @GetMapping("/message")
    public List<Greeting> getGreeting(@RequestBody Greeting greeting) {
        return greetingService.greetingMessage(greeting);
    }

    //Add the data using this function
    @PostMapping("/add")
    public Greeting addGreeting(@RequestBody Greeting greeting) {
        return greetingService.addGreeting(greeting);
    }

    //Method to get data by id using path-variable
    @GetMapping("/getId/{id}")
    public Greeting getById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    //Method to get data by id using Requesting Parameter
    @RequestMapping("/getId")
    public Greeting getIdUsingParam(@RequestParam(value = "id") Long id) {
        return greetingService.getGreetingById(id);
    }

    //Method to get list of all messages using GetAll path-variable
    @GetMapping("/getall")
    public List<Greeting> getAll() {
        return greetingService.getAllGreeting();
    }

    //Editing the database by providing the body using postman
    @RequestMapping("/edit-data")
    public Greeting editDatabase(@RequestBody Greeting greeting) {
        return greetingService.editDatabase(greeting);
    }

    //Editing only the message in the database
    @RequestMapping("/edit-message")
    public Greeting editMessage(@RequestBody Greeting greeting) {
        return greetingService.editMessage(greeting);
    }
}

