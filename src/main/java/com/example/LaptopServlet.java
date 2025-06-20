// LaptopServlet.java
package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/laptops")
public class LaptopServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Laptop> laptops = new ArrayList<>();
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM laptop");
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Laptop laptop = new Laptop();
                laptop.setLid(rs.getInt("lid"));
                laptop.setBrand(rs.getString("brand"));
                laptop.setModel(rs.getString("model"));
                laptops.add(laptop);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        request.setAttribute("laptops", laptops);
        request.getRequestDispatcher("laptops.jsp").forward(request, response);
    }
}






























