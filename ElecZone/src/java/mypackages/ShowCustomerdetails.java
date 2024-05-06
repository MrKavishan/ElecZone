/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "ShowCustomerdetails", urlPatterns = {"/ShowCustomerdetails"})
public class ShowCustomerdetails extends HttpServlet {
    
    private customerDAO customerDAO;
    
    public ShowCustomerdetails(){ 
        this.customerDAO = new customerDAO();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("show details");
        try {
            listallcustomer(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ShowCustomerdetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doDelete(request, response);
    }
    
    
    private void listallcustomer (HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException, SQLException {
        
        try {
            List<Customer> listcustomer = customerDAO.selectallCustomers();
            RequestDispatcher rs= req.getRequestDispatcher("/customerlist.jsp");
            req.setAttribute("customerlist", listcustomer);
            rs.forward(req, res);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
