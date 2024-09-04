package com.example;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/form")
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String email = request.getParameter("email");

        boolean hasError = false;

        if (username == null || username.isEmpty()) {
            out.println("Username is required.<br>");
            hasError = true;
        }
        if (email == null || email.isEmpty()) {
            out.println("Email is required.<br>");
            hasError = true;
        } else if (!email.matches("\\b[\\w.%-]+@[\\w.-]+\\.\\w{2,4}\\b")) {
            out.println("Invalid email format.<br>");
            hasError = true;
        }

        if (!hasError) {
            out.println("Form submitted successfully!");
        }

        out.println("<a href='index.html'>Back</a>");
    }
}

