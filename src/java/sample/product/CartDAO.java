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
import java.time.LocalDate;
import sample.utils.DBUtils;

/**
 *
 * @author THANH BINH
 */
public class CartDAO {

    private static final String INSERT_ORDER = "INSERT INTO [tblOrder] (userId, useraddress, userphone, date, total) VALUES (?, ?, ?, ?, ?)";
    private static final String INSERT_ORDER_DETAILS = "INSERT INTO [tblOrderDetails] (orderId, bookID, quantity) VALUES (?, ?, ?)";

    public int addOrder(String userId, String useraddress, String userphone, double total) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int orderId = -1;

        LocalDate currentDate = LocalDate.now();
        Date date = Date.valueOf(currentDate);

        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(INSERT_ORDER, PreparedStatement.RETURN_GENERATED_KEYS);
            ptm.setString(1, userId);
            ptm.setString(2, useraddress);
            ptm.setString(3, userphone);
            ptm.setDate(4, date);
            ptm.setDouble(5, total);

            int eR = ptm.executeUpdate();

            if (eR > 0) {
                rs = ptm.getGeneratedKeys();
                if (rs.next()) {
                    orderId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR AT DAO" + e.toString());
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
        return orderId;
    }

    public boolean addOrderDetails(int orderId, String bookID, int quantity) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(INSERT_ORDER_DETAILS, PreparedStatement.RETURN_GENERATED_KEYS);
            ptm.setInt(1, orderId);
            ptm.setString(2, bookID);
            ptm.setInt(3, quantity);
            int eR = ptm.executeUpdate();
            return eR > 0;

        } catch (SQLException e) {
            System.out.println("ERROR AT DAO" + e.toString());
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
        return false;
    }

    //    public int insertOrders(String userId) throws Exception {
//        String sql = INSERT_ORDERS;
//        LocalDate currentDate = LocalDate.now();
//        Date date = Date.valueOf(currentDate);
//        try {
//
//            PreparedStatement ps = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            ps.setString(1, userId);
//            ps.setDate(2, date);
//
//            int rowAffected = ps.executeUpdate();
//
//            if (rowAffected > 0) {
//                ResultSet rs = ps.getGeneratedKeys();
//                if (rs.next()) {
//                    return rs.getInt(1);
//                }
//            }
//
//            ps.close();
//
//        } catch (SQLException ex) {
//            System.out.println("Error connecting to the database: " + ex.getMessage());
//        }
//
//        return -1;
//    }
//    public boolean insertOrdersDetails(CartDTO carts, int orderID) throws Exception {
//        String sql = INSERT_ORDER_DETAILS;
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//
//        try {
//            PreparedStatement ps = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            for (ProductInCart cart : carts) {
//                ps.setInt(1, orderID);
//                ps.setInt(2, cart.getProduct().getId());
//                ps.setInt(3, cart.getQuantity());
//                ps.setFloat(4, cart.getQuantity() * cart.getProduct().getPrice());
//                ps.addBatch();
//            }
//            int[] rowAffected = ps.executeBatch();
//            if (rowAffected.length > 0) {
//                System.out.println("OK");
//                return true;
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Error connect DB at CARTDAO.insertOrdersDetails" + ex.getMessage());
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (ptm != null) {
//                ptm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//
//        return false;
//    }
//    private int getGeneratedOrderId() throws SQLException {
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//
//        try {
//            conn = DBUtils.getConnection();
//            ptm = conn.prepareStatement("SELECT LAST_INSERT_ID()");
//            rs = ptm.executeQuery();
//            if (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println("Failed");
//        }
//        return -1;
//    }
}
