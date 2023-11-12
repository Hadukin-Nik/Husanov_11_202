package com.example.demotivators.pages;

import com.example.demotivators.MyStringHelper;
import com.example.demotivators.TemplatesLoader;
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        String root_buf = getServletContext().getRealPath("/");

        String filePath = MyStringHelper.getAStringBeforePattern(root_buf, "target") + "src\\main\\resources\\images";

        Part filePart = null;
        String fileName = String.valueOf(System.currentTimeMillis());

        try {
            filePart = request.getPart("file");
            filePart.write(filePath + fileName + ".jpg");
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

        /*
        try {
            response.sendRedirect(request.getContextPath() + "/menu");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
    }
}
