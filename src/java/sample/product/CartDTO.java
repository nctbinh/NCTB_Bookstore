/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.product;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author THANH BINH
 */
public class CartDTO {

    private Map<String, BookDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, BookDTO> cart) {
        this.cart = cart;
    }

    public Map<String, BookDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, BookDTO> cart) {
        this.cart = cart;
    }

    public boolean add(BookDTO book) {
        boolean check = false;
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            if (this.cart.containsKey(book.getBookID())) {
                int currentQuantity = this.cart.get(book.getBookID()).getQuantity();
                book.setQuantity(currentQuantity + book.getQuantity());
            } 
            this.cart.put(book.getBookID(), book);
            check = true;
        } catch (Exception e) {
        }

        return check;
    }

    public boolean change(String id, BookDTO book) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
                    this.cart.replace(id, book);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }

    public boolean remove(String id) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
                    this.cart.remove(id);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }
}
