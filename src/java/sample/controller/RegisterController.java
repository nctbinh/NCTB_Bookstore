/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.user.UserDAO;

/**
 *
 * @author THANH BINH
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    public static final String SUCCESS = "home.jsp";
    public static final String ERROR = "register.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            UserDAO dao = new UserDAO();
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            String rePassword = request.getParameter("rePassword");
            String fullName = request.getParameter("fullName");
            if (!password.equals(rePassword)) {
                request.setAttribute("PASSWORD_ERROR", "Password mismatch");
            }
            if (dao.checkLogin(userID, password) != null) {
                request.setAttribute("DUPLICATE_ERROR", "Username is already used");
            }
            if (password.equals(rePassword) && dao.checkLogin(userID, password) == null) {
                boolean flag = dao.addUser(userID, password, fullName);
                if (flag) {
                    url = SUCCESS;
                    session.setAttribute("USER", dao.checkLogin(userID, password));
                }
            }

        } catch (SQLException e) {
            log(e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
