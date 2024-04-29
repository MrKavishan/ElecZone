/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackages;

/**
 *
 * @author User
 */
public class Order {
    
    private int orderid;
    private String productname;
    private double price;
    private int quantity;
    private double totalprice;

    public Order(int orderid, String productname, double price, int quantity, double totalprice) {
        this.orderid = orderid;
        this.productname = productname;
        this.price = price;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }

    public Order(String productname, double price, int quantity, double totalprice) {
        this.productname = productname;
        this.price = price;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    

    
}
