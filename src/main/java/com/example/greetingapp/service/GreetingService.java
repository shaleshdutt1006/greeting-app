package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {

    private static final String template = "Hello, %s!";
    // An AtomicLong is used in applications such as automatically incremented sequence number
    private final AtomicLong counter = new AtomicLong();

    public Greeting greeting(String name) {
        // return a new Greeting class object with id values incremented by 1 every time and String
        //format to show message of hello and the name we pass on the Postman
        return new Greeting(counter.incrementAndGet(), String.format(template, name));

    }

}

