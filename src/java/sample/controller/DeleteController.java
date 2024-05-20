
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.product.BookDAO;

@WebServlet(name = "DeleteController", urlPatterns = {"/delete"})
public class DeleteController extends HttpServlet {

    public static final String SUCCESS = "staff.jsp";
    public static final String ERROR = "staff.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String searchParam = (String)session.getAttribute("SEARCH_PARAM");
            String bookID = request.getParameter("bookID");
            BookDAO dao = new BookDAO();
            boolean isDeleted = dao.deleteProduct(bookID);
            if (isDeleted) {
                url = SUCCESS;
                session.setAttribute("BOOK_LIST", dao.getBookListBySearchingAdmin(searchParam));
            }
        } catch (SQLException e) {
            System.out.println("Error at DeleteController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
