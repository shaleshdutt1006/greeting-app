package com.example.greetingapp.model;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
//@Entity annotation creates table structure in database
public class Greeting {
    @Id

    private final long id;
    private final String message;

    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Greeting() {
        id = 0;
        message = "";
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
