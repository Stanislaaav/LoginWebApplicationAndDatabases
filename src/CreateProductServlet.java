import beans.Product;
import utils.DBUtils;
import utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/createProduct"})
public class CreateProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CreateProductServlet() {
        super();
    }

    // When the user enters the product information, and click Submit.
    // This method will be called.
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);

        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String priceStr = request.getParameter("price");
        float price = 0;
        try {
            price = Float.parseFloat(priceStr);
        } catch (Exception e) {
        }

        Product product = new Product(code, name, price);

        String errorString = null;

        // Product ID is the string literal [a-zA-Z_0-9]
        // with at least 1 character
        String regex = "\\w+";

        if (code == null || !code.matches(regex)) {
            errorString = "Product code invalid";
        }

        if (errorString == null) {
            try {
                DBUtils.insetProduct(conn, product);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);

        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext().
                    getRequestDispatcher("/createProductView.jsp");
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/productList");
        }
    }

    // Show product creation page.
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext().
                getRequestDispatcher("/createProductView.jsp");
        dispatcher.forward(request, response);
    }
}
