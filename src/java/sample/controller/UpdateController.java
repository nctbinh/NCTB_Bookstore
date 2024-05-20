/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.product.BookDAO;
import sample.product.BookDTO;

/**
 *
 * @author THANH BINH
 */
@WebServlet(name = "UpdateMobileController", urlPatterns = {"/update"})
public class UpdateController extends HttpServlet {

    public static final String SUCCESS = "staff.jsp";
    public static final String ERROR = "staff.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            BookDAO dao = new BookDAO();
            String searchParam = (String)session.getAttribute("SEARCH_PARAM");
            String bookID = request.getParameter("bookID");
            String name = request.getParameter("name");
            String author = request.getParameter("author");
            String publishDateStr = request.getParameter("publishDate");
            String image = request.getParameter("image");
            String priceStr = request.getParameter("price");
            String quantityStr = request.getParameter("quantity");
            String statusStr = request.getParameter("status");

            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(quantityStr);
            boolean status = Boolean.parseBoolean(statusStr);
            java.sql.Date publishDate = java.sql.Date.valueOf(publishDateStr);

            boolean isUpdated = dao.updateProduct(bookID, name, author, publishDate, image, price, quantity, status);
            if (isUpdated == true) {
                url = SUCCESS;
                session.setAttribute("BOOK_LIST", dao.getBookListBySearchingAdmin(searchParam));
            }
        } catch (SQLException e) {
            System.out.println("Error at SearchByName" + e.toString());
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
