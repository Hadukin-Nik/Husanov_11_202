package com.example.demotivators.pages;

import com.example.demotivators.dao_s.MemesDAO;
import com.example.demotivators.entities.Mem;
import com.example.demotivators.helper_s.MyHelper;
import com.example.demotivators.helper_s.TemplatesLoader;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class MemRedact extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");

        Map<String, Object> root = new HashMap<>();
        Template temp = null;
        //description, tags, commentAllowed


        String URLAfterWebDomain = request.getRequestURI();

        if(URLAfterWebDomain.contains("/memes/") == false)
            return;

        int mem_id = Integer.parseInt(MyHelper.getAStringAfterPattern(URLAfterWebDomain, "memes/"));
        Mem mem = MemesDAO.findMemInDB(mem_id);

        if(mem != null) {
            temp = TemplatesLoader.getConfiguration().getTemplate("memRedactor.ftl");

            Cookie admin = MyHelper.getSpecificCookie(request.getCookies(), "admin");
            Cookie userId = MyHelper.getSpecificCookie(request.getCookies(), "user_id");

            boolean isHaveRights = false;

            if(userId != null) {
                if(admin != null) {
                    isHaveRights = true;
                }

                if(Integer.parseInt(userId.getValue()) == mem.getUser_id()) {
                    isHaveRights = true;
                }
            }

            root.put("mem", mem);
            root.put("isHaveRights", isHaveRights);
        } else {
            temp = TemplatesLoader.getConfiguration().getTemplate("error.ftl");

            root.put("error_message", "Wrong mem id");
        }

        try {
            temp.process(root, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        Boolean isCommentsAllowed = request.getParameter("isCommentsAllowed") != null;
        String description = request.getParameter("description");
        String tags = request.getParameter("tags");

        String URLAfterWebDomain = request.getRequestURI();

        int mem_id = Integer.parseInt(MyHelper.getAStringAfterPattern(URLAfterWebDomain, "memes/"));

        MemesDAO.update(mem_id, isCommentsAllowed, description, tags);

        try {
            response.sendRedirect(request.getContextPath() + "/scroll");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
