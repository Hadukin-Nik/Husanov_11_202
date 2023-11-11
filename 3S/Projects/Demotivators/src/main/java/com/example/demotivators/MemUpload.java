package com.example.demotivators;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String root = getServletContext().getRealPath("/");
        String filePath = root + "images/";


        Part filePart = null;
        try {
            filePart = request.getPart("file");

            String fileName = String.valueOf(System.currentTimeMillis());
            filePart.write(filePath + fileName+".jpg");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }


        /*
        try {
            response.sendRedirect(request.getContextPath() + "/menu");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
    }
}
