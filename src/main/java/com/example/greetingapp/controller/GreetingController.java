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
    GreetingService greetingService;

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
    @GetMapping("/getId")
    public Greeting getIdUsingParam(@RequestParam(value = "id") Long id) {
        return greetingService.getGreetingById(id);
    }

    //Method to get list of all messages using GetAll path-variable
    @GetMapping("/getall")
    public List<Greeting> getAll() {
        return greetingService.getAllGreeting();
    }

    //Editing only the database if present otherwise return null
    @PutMapping("/edit-database/{id}")
    public Greeting editMessage(@PathVariable(value = "id") long id, @RequestBody Greeting greeting) {
        return greetingService.editDatabase(id, greeting);
    }
    //Editing the database by providing the body using postman if present then edit otherwise add the data
    @PutMapping("/edit-data")
    public Greeting editDatabase(@RequestBody Greeting greeting) {
        return greetingService.editDatabase(greeting);
    }

    //deleting the database
    @DeleteMapping("/delete-database")
    public List<Greeting> deleteInDatabase(@RequestParam Greeting greeting) {
        return greetingService.deleteInDatabase(greeting);
    }


}

