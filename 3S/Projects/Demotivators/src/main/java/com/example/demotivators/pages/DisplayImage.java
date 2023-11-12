package com.example.demotivators.pages;

import com.example.demotivators.MyStringHelper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DisplayImage extends HttpServlet {
    public final String imagesBase = "C:\\Users\\husan\\Desktop\\Husanov_11_202\\3S\\Projects\\Demotivators\\src\\main\\resources\\images\\";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String URLAfterWebDomain = request.getRequestURI();

        if(URLAfterWebDomain.contains("/images/") == false)
            return;

        String relativeImagePath = MyStringHelper.getAStringAfterPattern(URLAfterWebDomain, "images");

        System.out.println("\nFetching image from "+imagesBase+relativeImagePath);
        response.setContentType("image/jpeg");

        ServletOutputStream outStream;
        outStream = response.getOutputStream();
        FileInputStream fin = new FileInputStream(imagesBase+relativeImagePath);

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(outStream);
        int ch = 0;
        while((ch=bin.read())!=-1)
            bout.write(ch);

        bin.close();
        fin.close();
        bout.close();
        outStream.close();
    }
}