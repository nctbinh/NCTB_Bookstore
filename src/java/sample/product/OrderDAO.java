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
public class OrderDAO {

    public static final String GET_ORDER_LIST = "SELECT * FROM TBLORDER";
    public static final String GET_ORDER = "SELECT o.orderID, o.userID, o.useraddress, o.userphone, o.date, o.total, od.bookID, od.quantity FROM tblOrder o INNER JOIN tblOrderDetails od ON o.orderID = od.orderID";

    public List<OrderDTO> getOrderList() throws SQLException {

        List<OrderDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ORDER_LIST);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    String userID = rs.getString("userID");
                    String useraddress = rs.getString("useraddress");
                    String userphone = rs.getString("userphone");
                    Date date = rs.getDate("date");
                    double total = rs.getDouble("total");

                    OrderDTO order = new OrderDTO(orderID, userID, useraddress, userphone, date, total);
                    list.add(order);
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

}
