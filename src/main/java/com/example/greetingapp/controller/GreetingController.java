package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class GreetingController {

    private static final String template = "Hello, %s!";
    // An AtomicLong is used in applications such as automatically incremented sequence number
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    // name has defaultValue world we change it using Postman
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        // return a new Greeting class object with id values incremented by 1 every time and String
        //format to show message of hello and the name we pass on the Postman
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


}
