package com.example.controller;

import com.example.dao.LaptopDAO;
import com.example.model.Laptop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/laptops/add")
public class AddLaptopServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set content type for plain form input (key-value) or JSON
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        String brand = request.getParameter("brand");
        String model = request.getParameter("model");

        // Basic validation
        if (brand == null || model == null || brand.isEmpty() || model.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Missing brand or model parameters.");
            return;
        }

        Laptop laptop = new Laptop();
        laptop.setBrand(brand);
        laptop.setModel(model);

        try {
            LaptopDAO dao = new LaptopDAO();
            boolean success = dao.insertLaptop(laptop);

            if (success) {
                response.setStatus(HttpServletResponse.SC_CREATED);
                response.getWriter().write("Laptop added successfully.");
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("Failed to add laptop.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Database error: " + e.getMessage());
        }
    }
}
