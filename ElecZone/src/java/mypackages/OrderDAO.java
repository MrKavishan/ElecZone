/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class OrderDAO {
    
    private String jdbcurl = "jdbc:mysql://localhost:3306/eleczonedb?useSSL=false";
    private String username = "root";
    private String password = "";
    
    private static final String INSERT_ORDER_SQL = "insert into orders"+"(productname,price,quantity,totalprice) values"+"(?,?,?,?);";
    private static final String SELECT_ALL_ORDER = "select * from orders";
    private static final String DELETE_ORDER_SQL = "delete from orders where orderid=?;";
    private static final String UPDATE_ORDER_SQL = "update orders set productname = ?, price = ?, quantity = ?, totalprice = ? where orderid=?;";
    private static final String SELECT_ORDER_BY_ID = "select * from orders where orderid=?;";
    
    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcurl,username,password);
            System.out.println("db connected");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
    
    public void insertOrder (Order order){
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL);
            preparedStatement.setString(1, order.getProductname());
            preparedStatement.setDouble(2, order.getPrice());
            preparedStatement.setInt(3, order.getQuantity());
            preparedStatement.setDouble(4, order.getTotalprice());
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean deleteOrder (int orderid){
        boolean rowdelete= false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_SQL);
            preparedStatement.setInt(1, orderid);
            rowdelete=preparedStatement.executeUpdate() > 0;
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowdelete;
    }
    
    public boolean updateOrder (Order order){
        boolean rowupdated= false;
        try {
            Connection connection= getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(UPDATE_ORDER_SQL);
            preparedStatement.setString(1, order.getProductname());
            preparedStatement.setDouble(2, order.getPrice());
            preparedStatement.setInt(3, order.getQuantity());
            preparedStatement.setDouble(4, order.getTotalprice());
            preparedStatement.setInt(5, order.getOrderid());
            rowupdated = preparedStatement.executeUpdate() > 0 ;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowupdated;
    }
    
    public List<Order> selectallOrder(){
        List<Order> orders= new ArrayList<>();
        Order order = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER);
            ResultSet rs = preparedStatement.executeQuery();
            
                while(rs.next()){
                    int orderid=rs.getInt("orderid");
                    String productname= rs.getString("productname");
                    Double price= rs.getDouble("price");
                    int quantity= rs.getInt("quantity");
                    Double totalprice = rs.getDouble("totalprice");
                    orders.add(new Order(orderid,productname,price,quantity,totalprice));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
    
    public Order selectOrder(int orderid) {
    Order order = null;
    try {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID);
        preparedStatement.setInt(1, orderid);// Set the id parameter
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            String productname = rs.getString("productname");
            Double price = rs.getDouble("price");
            Integer quantity = rs.getInt("quantity");
            Double totalprice = rs.getDouble("totalprice");
            order = new Order(orderid,productname,price,quantity,totalprice);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
}
