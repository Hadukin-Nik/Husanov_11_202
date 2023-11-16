package com.example.demotivators.pages;

import com.example.demotivators.dao_s.CommentsDAO;
import com.example.demotivators.dao_s.MemesDAO;
import com.example.demotivators.entities.Comment;
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
import java.util.Date;
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

        int memId = getId(URLAfterWebDomain);

        Mem mem = MemesDAO.findMemInDB(memId);

        if(mem != null && URLAfterWebDomain.endsWith("/edit")) {
            Cookie admin = MyHelper.getSpecificCookie(request.getCookies(), "admin");
            Cookie userId = MyHelper.getSpecificCookie(request.getCookies(), "user_id");

            boolean isHaveRights = false;

            if(userId != null) {
                if(admin != null) {
                    isHaveRights = true;
                }

                if(Integer.parseInt(userId.getValue()) == mem.getUserId()) {
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
            root.put("comments", CommentsDAO.getAllComments(memId));
        }

        try {
            temp.process(root, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    private int getId(String urlAfterWebDomain) {
        Pattern p = Pattern.compile("[0-9]+");

        Matcher m = p.matcher(urlAfterWebDomain);

        int memId = -1;

        if(m.find()) {
            memId = Integer.parseInt(m.group());
        }
        return memId;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String URLAfterWebDomain = request.getRequestURI();

        if(URLAfterWebDomain.endsWith("edit")) {
            int memId = getId(URLAfterWebDomain);
            Boolean deleteMem = request.getParameter("deleteMem") != null;

            if(deleteMem) {
                MemesDAO.delete(memId);

                return;
            }

            Boolean isCommentsAllowed = request.getParameter("isCommentsAllowed") != null;
            String description = request.getParameter("description");
            String tags = request.getParameter("tags");

            MemesDAO.update(memId, isCommentsAllowed, description, tags);

            try {
                response.sendRedirect(request.getContextPath() + "/scroll");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if(URLAfterWebDomain.endsWith("comments"))  {
            String comment = request.getParameter("comment");

            int memId = getId(URLAfterWebDomain);

            Cookie cookie = MyHelper.getSpecificCookie(request.getCookies(), "user_id");

            if(cookie == null) {
                response.sendError(404);
                return;
            }

            int userId = Integer.parseInt(cookie.getValue());
            Date date = new Date(System.currentTimeMillis());

            CommentsDAO.insert(new Comment(memId, userId, date, comment, 0, 0));

            try {
                response.sendRedirect(request.getContextPath() + "/memes/" + memId + "/comments");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
