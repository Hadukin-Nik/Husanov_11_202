package com.example._20230923;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ExitScreen extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        Map<String, Object> root = new HashMap<>();
        root.put("address", request.getContextPath());

        response.setContentType("text/html");
        Template temp = TemplatesLoader.getConfiguration().getTemplate("exitscreen.ftl");

        try {
            temp.process(root, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            doGet(request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
