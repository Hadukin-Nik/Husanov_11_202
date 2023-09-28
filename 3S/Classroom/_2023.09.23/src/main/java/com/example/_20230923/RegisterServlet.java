package com.example._20230923;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");

        out.println("<html><body>");
        // Hello

        out.println("<form method=\"Post\" action=\"\">\n" +
                "<input name = \"login\" value=\"\">\n" +
                "<input name = \"password\" value=\"\">\n" +
                "<input type=\"submit\" value=\"enter\">" +
                "</form>");
        out.println("<a href=\"\">Back</a>");

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        if((request.getParameter("login") != null && request.getParameter("password")!=null) && UsersContainer.addUser(request.getParameter("login"), request.getParameter("password"))) {
            try {
                response.sendRedirect(request.getContextPath() + "/vote");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
