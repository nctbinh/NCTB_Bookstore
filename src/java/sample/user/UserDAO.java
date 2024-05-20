package sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sample.utils.DBUtils;

public class UserDAO {

    private static final String LOGIN = "SELECT * FROM tblUser WHERE userID=? AND password=? ";
    private static final String LIST_USER = "SELECT * FROM tblUser;";
    private static final String DELETE_USER = "DELETE FROM tblUser\n" +
                                              "WHERE userID = ?;";
    private static final String ADD_USER = "INSERT INTO tblUser (userID, password, fullName, role) VALUES (?, ?, ?, ?);";
    

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    int roleID = rs.getInt("role");
                    user = new UserDTO(userID, fullName, roleID);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
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
        return user;
    }

    public boolean addUser(String userID, String password, String fullName) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_USER);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                ptm.setString(3, fullName);
                ptm.setInt(4, 1);
                int affectedRow = ptm.executeUpdate();
                if (affectedRow > 0) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR AT add dao" + e.toString());
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
