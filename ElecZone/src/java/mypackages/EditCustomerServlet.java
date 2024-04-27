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
@WebServlet(name = "EditCustomerServlet", urlPatterns = {"/EditCustomerServlet"})
public class EditCustomerServlet extends HttpServlet {
    
    private customerDAO customerDAO;
    
    public EditCustomerServlet(){ 
        this.customerDAO = new customerDAO();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("load edit cus");
        try {
            showeditcustomerform(request, response);
        } catch (SecurityException ex) {
            Logger.getLogger(EditCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        this.doGet(request, response);
    }
    
    private void showeditcustomerform (HttpServletRequest request, HttpServletResponse response)
            throws IOException,SecurityException,SQLException {
        
        try {
            int id= Integer.parseInt(request.getParameter("id"));
            Customer exitcustomer = customerDAO.selectCustomer(id);
            RequestDispatcher rd = request.getRequestDispatcher("/customerupdateform.jsp");
            request.setAttribute("customer", exitcustomer);
            rd.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
}

    
