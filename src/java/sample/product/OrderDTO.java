/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.product;

import java.util.Date;

/**
 *
 * @author THANH BINH
 */
public class OrderDTO {

    private int orderID;
    private String userID;
    private String useraddress;
    private String userphone;
    private Date date;
    private double total;

    public OrderDTO() {
    }

    public OrderDTO(int orderID, String userID, String useraddress, String userphone, Date date, double total) {
        this.orderID = orderID;
        this.userID = userID;
        this.useraddress = useraddress;
        this.userphone = userphone;
        this.date = date;
        this.total = total;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    

}
