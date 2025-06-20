// LaptopServlet.java
package com.example.controller;

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

import com.example.model.Laptop;
import com.example.util.DBUtil;

@WebServlet("/laptops")
public class LaptopServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
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
    
//    //delete code
//    @Override
//    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String lidParam = request.getParameter("lid");
//
//        if (lidParam == null || lidParam.isEmpty()) {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
//            response.getWriter().write("Missing 'lid' parameter");
//            return;
//        }
//
//        int lid;
//        try {
//            lid = Integer.parseInt(lidParam);
//        } catch (NumberFormatException e) {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
//            response.getWriter().write("Invalid 'lid' parameter");
//            return;
//        }
//
//        try (Connection conn = DBUtil.getConnection();
//             PreparedStatement stmt = conn.prepareStatement("DELETE FROM laptop WHERE lid = ?")) {
//
//            stmt.setInt(1, lid);
//            int rowsAffected = stmt.executeUpdate();
//
//            if (rowsAffected > 0) {
//                response.setStatus(HttpServletResponse.SC_OK); // 200
//                response.getWriter().write("Laptop deleted successfully.");
//            } else {
//                response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
//                response.getWriter().write("Laptop with lid " + lid + " not found.");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500
//            response.getWriter().write("Database error occurred.");
//        }
//    }

}






























