package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {
    @Autowired
    GreetingAppRepository greetingAppRepository;
    private static final String template = "Hello, %s %s %s %s!";
    // An AtomicLong is used in applications such as automatically incremented sequence number
    private final AtomicLong counter = new AtomicLong();


    public Greeting addGreeting(Greeting greeting) {
        String message = String.format(template, (greeting.toString().isEmpty()) ? "Hello World" : "My first name is :", greeting.getFirstName(),
                "And my Last name is :", greeting.getLastName());
        return greetingAppRepository.save(new Greeting(counter.incrementAndGet(), message, greeting.getFirstName(), greeting.getLastName()));
    }

    public List<Greeting> greetingMessage(Greeting greeting) {
        String message = String.format(template, (greeting.toString().isEmpty()) ? "Hello World" : "My first name is :", greeting.getFirstName(),
                "And my Last name is :", greeting.getLastName());
        greetingAppRepository.save(new Greeting(counter.incrementAndGet(), message, greeting.getFirstName(), greeting.getLastName()));
        return greetingAppRepository.findAll();
    }

}

