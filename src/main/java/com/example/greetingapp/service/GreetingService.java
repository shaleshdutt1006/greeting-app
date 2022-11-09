package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {
    @Autowired
    GreetingAppRepository greetingAppRepository;
    //%s means we are giving values to this later
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

    public Greeting getGreetingById(long id) {
        return greetingAppRepository.findById(id).get();
    }

    public List<Greeting> getAllGreeting() {
        return greetingAppRepository.findAll();
    }

    //Editing the database if present then change otherwise give null
    // using the greetingAppRepository.findById.getFirstName
    public Greeting editDatabase(long id, Greeting greeting) {
        Optional<Greeting> optional = greetingAppRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        } else {
            Greeting greeting1 = new Greeting(id, greeting);
            greetingAppRepository.save(greeting1);
            return greeting1;
        }
    }

    //Edit the database if present then change the data otherwise insert new data
    public Greeting editDatabase(Greeting greeting) {
        String message = String.format(template, (greeting.toString().isEmpty()) ? "Hello World" : "My first name is :", greeting.getFirstName(),
                "And my Last name is :", greeting.getLastName());
        return greetingAppRepository.save(new Greeting(greeting.getId(), message, greeting.getFirstName(), greeting.getLastName()));
    }

    public List<Greeting> deleteInDatabase(Greeting greeting) {
        greetingAppRepository.deleteById(greeting.getId());
        return greetingAppRepository.findAll();
    }
}

