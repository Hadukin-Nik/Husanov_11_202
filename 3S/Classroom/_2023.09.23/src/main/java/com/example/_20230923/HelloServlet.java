package com.example._20230923;

import java.io.*;
import java.util.Arrays;
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
        // Hello

        out.println("<form  method=\"Post\" action=\"\">\n" +
                    "<input name = \"login\" value=\"\">\n" +
                    "<input name = \"password\" value=\"\">\n" +
                    "<input type=\"submit\" value=\"enter\">" +

                "</form>");
        out.println("<h1>----------------------</h1>");

        out.println("<a href=\"register\">Register</a>");

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if((request.getParameter("login") != null && request.getParameter("password")!=null) && UsersContainer.checkUser(request.getParameter("login"), request.getParameter("password"))) {
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/vote");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        } else {
            doGet(request, response);
        }
    }

    public void destroy() {
    }
}