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
@WebServlet(name = "DeleteCustomerServlet", urlPatterns = {"/DeleteCustomerServlet"})
public class DeleteCustomerServlet extends HttpServlet {
    
    private customerDAO customerDAO;
    
    public DeleteCustomerServlet(){ 
        this.customerDAO = new customerDAO();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("delete customer");
        try {
            deletecustomer(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        this.doGet(request, response);
    }
    
    private void deletecustomer (HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException , SQLException {
        
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            customerDAO.deleteCustomer(id);
            res.sendRedirect("/ElecZone/ShowCustomerdetails");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
