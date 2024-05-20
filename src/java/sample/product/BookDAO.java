/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author THANH BINH
 */
public class BookDAO {

    private static final String GET_BOOK_LIST = "SELECT * FROM tblBook";
    private static final String GET_BOOK_LIST_BY_SEARCH = "SELECT * FROM tblBook WHERE name like ?";
    private static final String GET_BOOK = "SELECT * FROM tblBook WHERE bookID = ?";
    private static final String ADD_PRODUCT = "INSERT INTO tblBook (bookID, name, author, publishDate, image, price, quantity, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_PRODUCT = "DELETE FROM tblBook WHERE bookID = ?";
    private static final String CHECK_DUPLICATE = "SELECT COUNT(*) AS count FROM tblBook WHERE name = ?";
    private static final String UPDATE_PRODUCT = "UPDATE tblBook SET name = ?, author = ?, publishDate = ?, image = ?, price = ?, quantity = ?, status = ? WHERE bookID = ?";

    public List<BookDTO> getBookList() throws SQLException {

        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_BOOK_LIST);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    Date publishDate = rs.getDate("publishDate");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    list.add(new BookDTO(bookID, name, author, publishDate, image, price, quantity, status));
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error at SearchByNameController");
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<BookDTO> getBookListBySearching(String searchParam) throws SQLException {

        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_BOOK_LIST_BY_SEARCH);
                ptm.setString(1, "%" + searchParam + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    Date publishDate = rs.getDate("publishDate");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    if (status == true) {
                        list.add(new BookDTO(bookID, name, author, publishDate, image, price, quantity, status));
                    }
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error at SearchByNameController");
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<BookDTO> getBookListBySearchingAdmin(String searchParam) throws SQLException {

        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_BOOK_LIST_BY_SEARCH);
                ptm.setString(1, "%" + searchParam + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    Date publishDate = rs.getDate("publishDate");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");

                    list.add(new BookDTO(bookID, name, author, publishDate, image, price, quantity, status));

                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error at SearchByNameController");
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public BookDTO getBookByID(String bookID) throws SQLException {

        BookDTO book = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_BOOK);
                ptm.setString(1, bookID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    Date publishDate = rs.getDate("publishDate");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    if (status) {
                        book = new BookDTO(bookID, name, author, publishDate, image, price, quantity, status);
                    }
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error at SearchByNameController");
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return book;
    }

    public boolean addProduct(BookDTO book) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String query = ADD_PRODUCT;
                ptm = conn.prepareStatement(query);
                ptm.setString(1, book.getBookID());
                ptm.setString(2, book.getName());
                ptm.setString(3, book.getAuthor());
                ptm.setDate(4, new java.sql.Date(book.getPublishDate().getTime()));
                ptm.setString(5, book.getImage());
                ptm.setDouble(6, book.getPrice());
                ptm.setInt(7, book.getQuantity());
                ptm.setBoolean(8, book.isStatus());
                int rowsAffected = ptm.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error at addProduct");
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public boolean deleteProduct(String bookID) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String query = DELETE_PRODUCT;
                ptm = conn.prepareStatement(query);
                ptm.setString(1, bookID);
                int rowsAffected = ptm.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error at deleteProduct");
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public boolean updateProduct(String bookID, String name, String author, Date publishDate, String image, double price, int quantity, boolean status) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String query = UPDATE_PRODUCT;
                ptm = conn.prepareStatement(query);
                ptm.setString(1, name);
                ptm.setString(2, author);
                ptm.setDate(3, new java.sql.Date(publishDate.getTime()));
                ptm.setString(4, image);
                ptm.setDouble(5, price);
                ptm.setInt(6, quantity);
                ptm.setBoolean(7, status);
                ptm.setString(8, bookID);
                int rowsAffected = ptm.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error at updateProduct: " + e.getMessage());
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

}
