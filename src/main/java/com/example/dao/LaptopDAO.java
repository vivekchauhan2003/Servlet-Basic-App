package com.example.dao;

import com.example.model.Laptop;
import com.example.util.DBUtil;

import java.sql.*;

public class LaptopDAO {

    public Laptop getLaptopById(int lid) throws SQLException {
        Laptop laptop = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM laptop WHERE lid = ?")) {

            stmt.setInt(1, lid);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                laptop = new Laptop();
                laptop.setLid(rs.getInt("lid"));
                laptop.setBrand(rs.getString("brand"));
                laptop.setModel(rs.getString("model"));
            }
        }

        return laptop;
    }
    
    public boolean insertLaptop(Laptop laptop) throws SQLException {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "INSERT INTO laptop (brand, model) VALUES (?, ?)")) {

            stmt.setString(1, laptop.getBrand());
            stmt.setString(2, laptop.getModel());

            return stmt.executeUpdate() > 0;
        }
    }




    // Other methods like getAllLaptops(), deleteLaptop(), etc.
}
