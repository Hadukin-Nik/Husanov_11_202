package com.example.demotivators;

public class User {
    public String name;
    public String date;

    public User(String name, String date) {
        this.name = name;
        this.date = date;
    }
    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
