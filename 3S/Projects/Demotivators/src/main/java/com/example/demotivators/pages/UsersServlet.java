package com.example.demotivators.pages;

import com.example.demotivators.helper_s.TemplatesLoader;
import com.example.demotivators.entities.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

public class UsersServlet extends HttpServlet {
    public void init() {}
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");
        Map<String, Object> root = new HashMap<>();

        List<User> users = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM users");
            resultSet.next();
            do {
                users.add(new User(resultSet.getString(9), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getInt(6), resultSet.getInt(1)));
            } while(resultSet.next());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        root.put("users", users);


        Template temp = TemplatesLoader.getConfiguration().getTemplate("/usersTable.ftl");

        try {
            temp.process(root, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
