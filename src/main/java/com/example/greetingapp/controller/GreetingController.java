package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class GreetingController {

    @Autowired
    private GreetingService greetingService;
    @GetMapping("/greeting")

    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GreetingService().greeting(name);
    }


}
