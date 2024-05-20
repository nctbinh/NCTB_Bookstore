/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author THANH BINH
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String LOGIN_CONTROLLER = "login";
    private static final String LOGIN_PAGE = "login.jsp";
    private static final String STAFF_PAGE = "staff.jsp";
    private static final String REGISTER_PAGE = "register.jsp";
    private static final String REGISTER_CONTROLLER = "register";
    private static final String LOGOUT_CONTROLLER = "logout";
    private static final String VIEW_PRODUCT_CONTROLLER = "ViewAllProductController";
    private static final String UPDATE_CONTROLLER = "update";
    private static final String DELETE_CONTROLLER = "delete";
    private static final String ADD_PAGE = "add.jsp";
    private static final String ADD_CONTROLLER = "add";
    private static final String SHOP_PAGE = "books.jsp";
    private static final String HOME_PAGE = "ViewHomePageController";
    private static final String BOOK_DETAIL = "ViewBookDetailController";
    private static final String SEARCH_CONTROLLER = "searchByName";
    private static final String ADD_TO_CART_CONTROLLER = "AddToCartController";
    private static final String CART_PAGE = "cart.jsp";
    private static final String REMOVE_CONTROLLER = "RemoveItemController";
    private static final String CHECK_OUT_CONTROLLER = "CheckOutController";
    private static final String ABOUT_US_PAGE = "aboutUs.jsp";
    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String action = request.getParameter("action");
        try {
            if ("".equals(action)) {
                url = LOGIN_PAGE;
            } else if ("Login".equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if ("register".equals(action)) {
                url = REGISTER_PAGE;
            } else if ("Register".equals(action)) {
                url = REGISTER_CONTROLLER;
            } else if ("Logout".equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if ("View All Product".equals(action)) {
                url = VIEW_PRODUCT_CONTROLLER;
            } else if ("Update".equals(action)) {
                url = UPDATE_CONTROLLER;
            } else if ("Delete".equals(action)) {
                url = DELETE_CONTROLLER;
            } else if ("Add a new product".equals(action)) {
                url = ADD_PAGE;
            } else if ("Back".equals(action)) {
                url = STAFF_PAGE;
            } else if ("shop".equals(action)) {
                url = SHOP_PAGE;
            } else if ("home".equals(action)) {
                url = HOME_PAGE;
            } else if ("bookDetail".equals(action)) {
                url = BOOK_DETAIL;
            } else if ("Search".equals(action)) {
                url = SEARCH_CONTROLLER;
            } else if ("Add to cart".equals(action)) {
                url = ADD_TO_CART_CONTROLLER;
            } else if ("viewCart".equals(action)) {
                url = CART_PAGE;
            } else if ("remove".equals(action)) {
                url = REMOVE_CONTROLLER;
            } else if ("Check out".equals(action)) {
                url = CHECK_OUT_CONTROLLER;
            } else if ("aboutUs".equals(action)) {
                url = ABOUT_US_PAGE;
            } else if ("Search Books".equals(action)) {
                url = VIEW_PRODUCT_CONTROLLER;
            } else if ("Add".equals(action)) {
                url = ADD_CONTROLLER;
            }
        } catch (Exception e) {
            url = ERROR;
            System.out.println("ERROR AT MAINCONTROLLER" + e.toString());
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
