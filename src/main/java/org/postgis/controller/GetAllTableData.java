package org.postgis.controller;

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

import org.postgis.model.PostGisModel;
import com.example.util.DBUtil;

@WebServlet("/postgis")
public class GetAllTableData extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<PostGisModel> postGisModels = new ArrayList<>();
        
        try (Connection conn = DBUtil.getConnection();
        		PreparedStatement stmt = conn.prepareStatement(
        			    "SELECT id, seq, word, stdword, token, is_custom FROM postgis_export_0001"
        			);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
            	PostGisModel postGisModel = new PostGisModel();
            	postGisModel.setId(rs.getInt("id"));
            	postGisModel.setSeq(rs.getInt("seq"));
            	postGisModel.setWord(rs.getString("word"));
            	postGisModel.setStdword(rs.getString("stdword"));
            	postGisModel.setToken(rs.getInt("token"));
            	postGisModel.setIs_custom(rs.getBoolean("is_custom"));
            	postGisModels.add(postGisModel);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        request.setAttribute("postGisModels", postGisModels);
        request.getRequestDispatcher("postgis.jsp").forward(request, response);
    }

}












