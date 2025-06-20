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

    // Other methods like getAllLaptops(), deleteLaptop(), etc.
}
