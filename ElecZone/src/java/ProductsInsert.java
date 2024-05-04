/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Mr.Kshan
 */
@WebServlet("/ProductsInsert")
@MultipartConfig
public class ProductsInsert extends HttpServlet {
 private static final long serialVersionUID = 1L;
    
    // JDBC URL, username, and password for your MySQL database
    private static final String url = "jdbc:mysql://localhost:3306/ecommerceweb";
    private static final String username = "root";
    private static final String password = "";
   
    
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
       
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
     
        InputStream inputStream = null;
        Part filePart = request.getPart("image");
        if (filePart != null) {
            inputStream = filePart.getInputStream();
        }
        
        Connection connection = null;
        PreparedStatement st = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            connection = DriverManager.getConnection(url,username,password);
            
            
            String id = UUID.randomUUID().toString();
            
           
            String sql = "INSERT INTO products (id, name, price,category,description,image,quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
            st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, name);
            st.setString(3, category);
            st.setString(4, description);
            st.setDouble(5, price);
            st.setInt(6, quantity);
           
            if (inputStream != null) {
                st.setBlob(7, inputStream);
            }
          
            int rowsAffected = st.executeUpdate();
            
            if (rowsAffected > 0) {
                out.println("<h3>Product added successfully!</h3>");
            } else {
                out.println("<h3>Error adding product!</h3>");
            }
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        } finally {
            try {
                if (st != null) st.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                out.println("<h3>Error closing database connections: " + e.getMessage() + "</h3>");
            }
        }
    }
    }

   
  


