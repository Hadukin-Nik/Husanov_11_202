package com.example._30092023;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println(createSuppliersTable());
        out.println("</body></html>");
    }

    public void destroy() {
    }

    private String createSuppliersTable() {
        List<List<String>> run = JDBCExample.run();
        String header = Stream.of("sup_id", "sup_name", "street", "city", "state", "zip").map((String s) -> "<td>" + s + "</td>").collect(Collectors.joining());
        StringBuilder ans = new StringBuilder("<table> <tr>" + header + "</tr>");

        for (List<String> row : run) {
            ans.append("<tr>").append(row.stream().map((String s) -> "<td>" + s + "</td>").collect(Collectors.joining())).append("</tr>");
        }

        ans.append("</table>");
        return ans.toString();
    }
}