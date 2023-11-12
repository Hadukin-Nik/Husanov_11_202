package com.example.demotivators.dao_s;

import com.example.demotivators.entities.User;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.SimpleDateFormat;

import static com.example.demotivators.helper_s.HelperForDAO_s.hashString;
import static com.example.demotivators.helper_s.HelperForDAO_s.howManyUsers;

public class UsersDAO {

    public static boolean addUser(User user, String login, String password) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            if(checkUser(login, password) != null) {
                return false;
            }
            Statement st = conn.createStatement();

            int numberOfUsers = howManyUsers("users");

            st.executeQuery("INSERT INTO public.users(" +
                    "\"Name\", \"Nickname\", \"Telephone_number\", \"Registration_date\", \"Role\", \"Login\", \"Password\", \"User_id\")\n" +
                    "VALUES (\'"+user.getName()+"\', \'"+user.getNickname()+"\', \'"+
                    user.getTelephone_number()+"\', \'"+
                    (new java.sql.Date(user.getDate_registration().getTime())) +"\', \'"+
                    User.Role.toInt(user.getRole())+"\', \'"+
                    login+"\', \'"+hashString(password)+"\', \'"+numberOfUsers+"\');");

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static User checkUser(String login, String password) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM users WHERE \"Login\" = '" + login + "' " + " AND \"Password\" = '" + hashString(password) + "'");

            resultSet.next();
            if(resultSet != null) {
                return new User(resultSet.getString(1), resultSet.getString(2), resultSet.getLong(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(8));
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
