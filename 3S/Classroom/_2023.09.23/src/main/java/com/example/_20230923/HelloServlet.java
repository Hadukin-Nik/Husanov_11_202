package com.example._20230923;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");

        out.println("<html><body>");


        Template temp = TemplatesLoader.getConfiguration().getTemplate("hello.ftl");

        try {
            temp.process(null, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }



    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(login != null && password != null && UsersContainer.checkUser(login, password)) {
            response.addCookie(new Cookie("authorized", "true"));

            response.sendRedirect(request.getContextPath() + "/vote");
        } else {
            doGet(request, response);
        }
    }



    public void destroy() {
    }
}