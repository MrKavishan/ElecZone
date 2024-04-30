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
@WebServlet(name = "UpdateCustomerServlet", urlPatterns = {"/UpdateCustomerServlet"})
public class UpdateCustomerServlet extends HttpServlet {
    
    private customerDAO customerDAO;
    
    public UpdateCustomerServlet(){ 
        this.customerDAO = new customerDAO();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("update customer");
        try {
            updateCustomer(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException, SQLException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String mobile = request.getParameter("mobile");
            Customer updatecust = new Customer(id, name, email, address, mobile);
            
            boolean isUpdated = customerDAO.updateCustomer(updatecust);

            if (isUpdated) {
                List<Customer> updatedCustomers = customerDAO.selectallCustomers();
                request.setAttribute("customerlist", updatedCustomers);
                RequestDispatcher rd = request.getRequestDispatcher("/customerlist.jsp");
                rd.forward(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.println("<html><body><h3>Error: Unable to update customer details.</h3></body></html>");
            }

            } catch (Exception e) {
                e.printStackTrace();
                PrintWriter out = response.getWriter();
                out.println("<html><body><h3>Exception occurred: " + e.getMessage() + "</h3></body></html>");
            }
}

}
