package com.example.demotivators;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UsersContainer {
    private static Map<String, String> users;

    public UsersContainer() {
        users = new HashMap<>();
    }

    public static boolean addUser(String login, String password) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM users WHERE Login = '" + login + "' " + " AND Password = '" + password + "'");
            if(resultSet != null) {
                return false;
            } else {

                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int checkUser(String login, String password) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM users WHERE \"Login\" = '" + login + "' " + " AND \"Password\" = '" + password + "'");

            resultSet.next();
            if(resultSet != null) {
                return resultSet.getInt(5);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
