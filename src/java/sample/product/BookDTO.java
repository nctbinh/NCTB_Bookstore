/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.product;

import java.sql.Date;

/**
 *
 * @author THANH BINH
 */
public class BookDTO {

    private String bookID;
    private String name;
    private String author;
    private Date publishDate;
    private String image;
    private double price;
    private int quantity;
    private boolean status;

    public BookDTO() {
    }

    public BookDTO(String bookID, String name, String author, Date publishDate, String image, double price, int quantity, boolean status) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    Object getMobileId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
