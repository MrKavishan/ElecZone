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
@WebServlet(name = "ShowOrderdetails", urlPatterns = {"/ShowOrderdetails"})
public class ShowOrderdetails extends HttpServlet {
    
    private OrderDAO orderDAO;
    
    public ShowOrderdetails(){ 
        this.orderDAO = new OrderDAO();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("default");
            try {
                listallorders(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ShowOrderdetails.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             this.doGet(request, response);
    }
    
    private void listallorders (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        
        try {
            List<Order> listorder= orderDAO.selectallOrder();
            RequestDispatcher rs= request.getRequestDispatcher("/orderlist.jsp");
            request.setAttribute("orderlist", listorder);
            rs.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

}
