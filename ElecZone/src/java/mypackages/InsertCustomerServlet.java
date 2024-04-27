/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "InsertCustomerServlet", urlPatterns = {"/InsertCustomerServlet"})
public class InsertCustomerServlet extends HttpServlet {

    private customerDAO customerDAO;
    
    public InsertCustomerServlet(){ 
        this.customerDAO = new customerDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            insertcustomer(request, response);
        } catch (SecurityException ex) {
            Logger.getLogger(InsertCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       this.doGet(request, response);
    }

    private void insertcustomer (HttpServletRequest req, HttpServletResponse res)
            throws IOException , SecurityException, SQLException {
        
        try {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String address = req.getParameter("address");
            String mobile = req.getParameter("mobile");
            Customer newcustomer = new Customer(name,email,address,mobile);
            customerDAO.insertCustomer(newcustomer);
            //add customer table file path
            res.sendRedirect("customerlist.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
