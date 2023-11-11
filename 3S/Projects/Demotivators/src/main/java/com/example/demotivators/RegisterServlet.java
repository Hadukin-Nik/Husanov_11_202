package com.example.demotivators;

import freemarker.template.Template;
import freemarker.template.TemplateException;


import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");
        Map<String, Object> root = new HashMap<>();
        root.put("address", request.getContextPath());

        Template temp = TemplatesLoader.getConfiguration().getTemplate("register.ftl");

        try {
            temp.process(root, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(login != null && password != null && (UsersContainer.checkUser(login, password) < 0)) {
            try {
                UsersContainer.addUser(login, password);
                response.sendRedirect(request.getContextPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if(login != null && password != null) {
            try {
                response.sendError(403);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
