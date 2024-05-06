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
@WebServlet(name = "DeleteOrderServlet", urlPatterns = {"/DeleteOrderServlet"})
public class DeleteOrderServlet extends HttpServlet {

    private OrderDAO orderDAO;
    
    public DeleteOrderServlet(){ 
        this.orderDAO = new OrderDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("delete order");
        try {
            deleteorder(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
    /*
    private void deleteorder (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException , SQLException {
        
        try {
            String orderIdParameter = request.getParameter("orderid");
            if (orderIdParameter != null && !orderIdParameter.isEmpty()) {
                int orderid = Integer.parseInt(orderIdParameter);
                // Rest of your code here
            } else {
                // Handle the case when the parameter is missing or null
            }

            orderDAO.deleteOrder(orderid);
            response.sendRedirect("/ElecZone/ShowOrderdetails");
        
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
*/
    private void deleteorder(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException, SQLException {

    String orderIdParameter = request.getParameter("orderid");
    if (orderIdParameter != null && !orderIdParameter.isEmpty()) {
        try {
            int orderid = Integer.parseInt(orderIdParameter);
            orderDAO.deleteOrder(orderid);
            response.sendRedirect("/ElecZone/ShowOrderdetails");
        } catch (NumberFormatException e) {
            // Handle the case when the parameter cannot be parsed into an integer
            e.printStackTrace();
            // You might want to handle this error by displaying a message to the user or logging it
        }
    } else {
        // Handle the case when the "orderid" parameter is missing or null
        // For example, you could redirect the user to an error page or display a message
        response.sendRedirect("/errorPage.jsp"); // Replace "/errorPage.jsp" with the appropriate error page URL
    }
}


}
