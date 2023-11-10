package com.example.demotivators;

import java.util.HashMap;
import java.util.Map;

public class UsersContainer {
    private static Map<String, String> users;

    public UsersContainer() {
        users = new HashMap<>();
    }

    public static boolean addUser(String login, String password) {
        if(users == null) {
            users = new HashMap<>();
        }
        if(users.containsKey(login)) {
            return false;
        } else {
            users.put(login, password);
        }
        return true;
    }

    public static boolean checkUser(String login, String password) {
        if(users == null) {
            users = new HashMap<>();
        }
        if(!users.containsKey(login)) {
            return false;
        } else {
            return users.get(login).equals(password);
        }
    }
}
