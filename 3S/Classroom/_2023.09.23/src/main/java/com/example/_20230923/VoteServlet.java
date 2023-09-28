package com.example._20230923;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "voteServlet", value = "/vote-servlet")
public class VoteServlet extends HttpServlet {
/*
* redirect(req, resp, http)
* peq.addCoockie("sad" "password")
*
* <form method = 'POST'>
* */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        boolean isVoted = Arrays.stream(request.getCookies()).filter(c -> {return c.getName().equals("voted");}).count() > 0;

        if(isVoted) {
            response.sendRedirect(request.getContextPath() + "/exit");
        } else if(request.getParameter("option1") != null) {
            response.addCookie(new Cookie("voted", "fuck"));
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        // Hello

        out.println("<form name=\"VoteForm\" method=\"Post\" action=\"exit\">\n" +
                    "<input type=radio name=\"option1\" value=\"like\">I like it !<br>\n" +
                    "<input type=radio name=\"option1\" value=\"dislike\">I hate it !<br>\n" +
                    "<input type=\"submit\" value=\"Vote\">\n" +

                "</form>");
        out.println("<a href=\"\">Send</a>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
