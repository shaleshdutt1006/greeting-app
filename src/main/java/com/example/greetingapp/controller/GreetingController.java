package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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


}
