/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sample.product.BookDAO;
import sample.product.BookDTO;
import sample.product.CartDAO;
import sample.product.CartDTO;
import sample.user.UserDTO;

/**
 * @author THANH BINH
 */
@WebServlet(name = "CheckOutController", urlPatterns = {"/CheckOutController"})
public class CheckOutController extends HttpServlet {


    public static final String SUCCESS = "invoice.jsp";
    public static final String ERROR = "cart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();

            List<BookDTO> list = new ArrayList<>();

            BookDAO bDao = new BookDAO();

            CartDTO cart = (CartDTO) session.getAttribute("CART");
            CartDAO dao = new CartDAO();

            UserDTO user = (UserDTO) session.getAttribute("USER");

            String userAddress = request.getParameter("useraddress");
            String userphone = request.getParameter("userphone");
            String total = request.getParameter("total");


            int id = dao.addOrder(user.getUserID(), userAddress, userphone, Double.parseDouble(total));

            for (Map.Entry<String, BookDTO> entry : cart.getCart().entrySet()) {
                String quantity = request.getParameter("quantity" + entry.getValue().getBookID());
                entry.getValue().setQuantity(Integer.parseInt(quantity));
                dao.addOrderDetails(id, entry.getValue().getBookID(), entry.getValue().getQuantity());
                BookDTO book = bDao.getBookByID(entry.getValue().getBookID());
                book.setQuantity(Integer.parseInt(quantity));
                list.add(book);
                url = SUCCESS;
            }

            cart = new CartDTO();
            session.setAttribute("CART", cart);
            session.setAttribute("ITEMS_LIST", list);
            session.setAttribute("ADDRESS", userAddress);
            session.setAttribute("PHONE", userphone);
            session.setAttribute("TOTAL", total);

        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
