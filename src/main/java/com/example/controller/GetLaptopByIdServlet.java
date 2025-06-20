package com.example.controller;

import com.example.dao.LaptopDAO;
import com.example.model.Laptop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/laptops/*")
public class GetLaptopByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pathInfo = request.getPathInfo(); // e.g. /101
        if (pathInfo == null || pathInfo.equals("/")) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Missing laptop ID.");
            return;
        }

        try {
            int lid = Integer.parseInt(pathInfo.substring(1)); // remove leading '/'
            LaptopDAO dao = new LaptopDAO();
            Laptop laptop = dao.getLaptopById(lid);

            if (laptop != null) {
                response.setContentType("text/plain");
                response.getWriter().write("LID: " + laptop.getLid() + "\nBrand: " + laptop.getBrand() + "\nModel: " + laptop.getModel());
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("Laptop not found for ID: " + lid);
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Invalid ID format.");
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("DB error: " + e.getMessage());
        }
    }
}



























