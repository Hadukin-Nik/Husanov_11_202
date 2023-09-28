package com.example._20230909;

import java.io.*;
import javax.servlet.http.*;

public class Visitor extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        if(name.equals("")) {
            name = "Anon";
        }
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Hi, " + name + "!"+ "</h1>");
        out.println("<a href=\"hello\">back</a>");
        out.println("</body></html>");
    }

}
