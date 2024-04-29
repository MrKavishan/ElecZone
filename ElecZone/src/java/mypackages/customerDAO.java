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
public class customerDAO {
    
    private String jdbcurl = "jdbc:mysql://localhost:3306/eleczonedb?useSSL=false";
    private String username = "root";
    private String password = "";
    
    private static final String INSERT_CUS_SQL = "insert into customers"+"(name,email,address,mobile) values"+"(?,?,?,?);";
    private static final String SELECT_ALL_CUS = "select * from customers";
    private static final String DELETE_CUS_SQL = "delete from customers where id=?;";
    private static final String UPDATE_CUS_SQL = "update customers set name = ?, email = ?, address = ?, mobile = ? where id=?;";
    private static final String SELECT_CUS_BY_ID = "select * from customers where id=?;";
    
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
    
    public void insertCustomer (Customer customer){
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUS_SQL);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getMobile());
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean deleteCustomer (int id){
        boolean rowdelete= false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUS_SQL);
            preparedStatement.setInt(1, id);
            rowdelete=preparedStatement.executeUpdate() > 0;
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowdelete;
    }
    
   public List<Customer> selectallCustomers(){
        List<Customer> customers= new ArrayList<>();
        Customer customer = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUS);
            ResultSet rs = preparedStatement.executeQuery();
            
                while(rs.next()){
                    int id=rs.getInt("id");
                    String name= rs.getString("name");
                    String email= rs.getString("email");
                    String address= rs.getString("address");
                    String mobile = rs.getString("mobile");
                    customers.add(new Customer(id,name,email,address,mobile));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
   
    public Customer selectCustomer(int id) {
    Customer customer = null;
    try {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUS_BY_ID);
        preparedStatement.setInt(1, id); // Set the id parameter
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");
            String address = rs.getString("address");
            String mobile = rs.getString("mobile");
            customer = new Customer(id, name, email, address, mobile);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    
    public boolean updateCustomer (Customer customer){
        boolean rowupdated= false;
        try {
            Connection connection= getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(UPDATE_CUS_SQL);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getMobile());
            preparedStatement.setInt(5, customer.getId());
            rowupdated = preparedStatement.executeUpdate() > 0 ;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowupdated;
    }
}
