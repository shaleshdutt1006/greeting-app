package com.example.greetingapp.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@Entity annotation creates table structure in database
public class Greeting {
    @Id
    @GeneratedValue
    private long id;
    private String message;
    private String firstName;
    private String lastName;

    public Greeting(long id, String message, String firstName, String lastName) {
        this.id = id;
        this.message = message;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Greeting(long id) {
        this.id = id;
    }

    public Greeting() {
    }

    public Greeting(Long id, Greeting greeting) {
        this.id = id;
        this.message = greeting.message;
        this.firstName = greeting.getFirstName();
        this.lastName = greeting.getLastName();
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }


    public void setLastName(String name) {
        this.lastName = name;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }


}
