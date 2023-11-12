package com.example.demotivators.pages;

import com.example.demotivators.helper_s.TemplatesLoader;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StarterWindowServlet extends HttpServlet {
    public void init() {}
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");
        Map<String, Object> root = new HashMap<>();
        root.put("backToAuthorisation", request.getContextPath());
        root.put("toAccount", request.getContextPath() + "/pc");
        root.put("toScroll", request.getContextPath() + "/scroll");
        root.put("toUsers", request.getContextPath() + "/users");
        root.put("toMemUpload", request.getContextPath() + "/mem_upload");

        root.put("x", Arrays.stream(request.getCookies()).filter(t -> t.getName().equals("admin")).count());

        Template temp = TemplatesLoader.getConfiguration().getTemplate("/starterWindow.ftl");

        try {
            temp.process(root, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
