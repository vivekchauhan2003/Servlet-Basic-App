package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/hellow")
public class HelloWorldServlet extends HttpServlet {

    private String message;

    @Override
    public void init() throws ServletException {
        // One-time initialization
        message = "Hello, Servlet World!";
        System.out.println("HelloWorldServlet: init() called.");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // Actual logic to write the response
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Hello Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>This is a simple Servlet example.</p>");
        out.println("</body>");
        out.println("</html>");
        System.out.println("HelloWorldServlet: doGet() called.");
    }

    
    @Override
    public void destroy() {
        // Cleanup resources
        System.out.println("HelloWorldServlet: destroy() called.");
    }
}































