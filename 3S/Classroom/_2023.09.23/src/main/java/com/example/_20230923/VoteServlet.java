package com.example._20230923;

import freemarker.template.Template;
import freemarker.template.TemplateException;

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
        Cookie[] cookies = request.getCookies();


        if(!isAuthorised(cookies)) {
            response.sendError(403);

            return;
        }

        boolean isVoted = Arrays.stream(cookies).anyMatch(c -> c.getName().equals("voted"));

        if(isVoted) {
            response.sendRedirect(request.getContextPath() + "/exit");
        }

        PrintWriter out = response.getWriter();

        Template temp = TemplatesLoader.getConfiguration().getTemplate("vote.ftl");

        try {
            temp.process(null, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.addCookie(new Cookie("voted", "fuck"));

        response.sendRedirect(request.getContextPath() + "/exit");
    }

    private boolean isAuthorised(Cookie[] cookies) {
        if(cookies == null) return false;
        return Arrays.stream(cookies).anyMatch(c -> c.getName().equals("authorized"));
    }
}
