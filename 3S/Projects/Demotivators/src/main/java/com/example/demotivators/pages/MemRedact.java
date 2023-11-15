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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemRedact extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");

        Map<String, Object> root = new HashMap<>();
        Template temp = null;
        //description, tags, commentAllowed


        String URLAfterWebDomain = request.getRequestURI();

        Pattern p = Pattern.compile("[0-9]+");

        Matcher m = p.matcher(URLAfterWebDomain);

        int mem_id = -1;

        if(m.find()) {
            mem_id = Integer.parseInt(m.group());
        }

        Mem mem = MemesDAO.findMemInDB(mem_id);

        if(mem != null && URLAfterWebDomain.endsWith("/edit")) {
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

            if(isHaveRights) {
                temp = TemplatesLoader.getConfiguration().getTemplate("memRedactor.ftl");
            } else {
                temp = TemplatesLoader.getConfiguration().getTemplate("mempage.ftl");
            }

        } else if (URLAfterWebDomain.endsWith("/comments")){
            temp = TemplatesLoader.getConfiguration().getTemplate("mempage.ftl");

            root.put("mem", mem);
        }

        try {
            temp.process(root, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String URLAfterWebDomain = request.getRequestURI();

        if(URLAfterWebDomain.endsWith("edit")) {
            int mem_id = Integer.parseInt(MyHelper.getAStringAfterPattern(URLAfterWebDomain, "memes/"));

            Boolean deleteMem = request.getParameter("deleteMem") != null;

            if(deleteMem) {
                MemesDAO.delete(mem_id);
            }

            Boolean isCommentsAllowed = request.getParameter("isCommentsAllowed") != null;
            String description = request.getParameter("description");
            String tags = request.getParameter("tags");

            MemesDAO.update(mem_id, isCommentsAllowed, description, tags);

            try {
                response.sendRedirect(request.getContextPath() + "/scroll");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if(URLAfterWebDomain.endsWith("comments"))  {

        }
    }
}
