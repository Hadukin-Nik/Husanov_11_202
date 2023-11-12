package com.example.demotivators.pages;

import com.example.demotivators.Config;
import com.example.demotivators.dao_s.MemesDAO;
import com.example.demotivators.entities.Mem;
import com.example.demotivators.helper_s.MyHelper;
import com.example.demotivators.helper_s.TemplatesLoader;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@MultipartConfig
public class MemUpload extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");

        Map<String, Object> root = new HashMap<>();
        Template temp = TemplatesLoader.getConfiguration().getTemplate("memUpload.ftl");

        try {
            temp.process(root, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        Boolean isCommentsAllowed = request.getParameter("isCommentsAllowed") != null;
        String description = request.getParameter("description");


        String root_buf = getServletContext().getRealPath("/");


        Part filePart = null;
        String fileName = UUID.randomUUID().toString();

        try {
            filePart = request.getPart("file");
            filePart.write(Config.sourceImagePath + fileName + ".jpg");
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        PrintWriter out = response.getWriter();

        response.setContentType("text/html");

        Map<String, Object> vars = new HashMap<>();
        vars.put("img_src", "images/" + fileName + ".jpg");

        Template temp = TemplatesLoader.getConfiguration().getTemplate("afterMemUpload.ftl");

        try {
            temp.process(vars, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
        Cookie[] cookies = request.getCookies();

        int user_id = Integer.parseInt(MyHelper.getSpecificCookie(cookies, "user_id").getValue());


        MemesDAO.InsertMem(new Mem(user_id, fileName + ".jpg", description, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), isCommentsAllowed));
    }


}
