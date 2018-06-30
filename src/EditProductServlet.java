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

@WebServlet(urlPatterns = {"/editProduct"})
public class EditProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EditProductServlet() {
        super();
    }

    // Show product edit page.
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conn = MyUtils.getStoredConnection(request);

        String code = request.getParameter("code");

        Product product = null;

        String errorString = null;

        try{
            product = DBUtils.findProduct(conn, code);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if(errorString != null && product ==null) {
            response.sendRedirect(request.getServletPath() + "/productList");
            return;
        }

        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);

        RequestDispatcher dispatcher = request.getServletContext().
                getRequestDispatcher("/editProductView.jsp");
        dispatcher.forward(request, response);
    }


    // After the user modifies the product information, and click Submit.
    // This method will be executed.
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conn = MyUtils.getStoredConnection(request);

        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String priceStr = request.getParameter("price");
        float price = 0;
        try{
            price = Float.parseFloat(priceStr);
        } catch (Exception e){
        }
        Product product = new Product(code, name, price);

        String errorString = null;

        try{
            DBUtils.updateProduct(conn, product);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);

        if(errorString != null){
            RequestDispatcher dispatcher = request.getServletContext().
                    getRequestDispatcher("/editProductView.jsp");
        }
        // If everything nice.
        // Redirect to the product listing page.
        else{
            response.sendRedirect(request.getContextPath() + "/productList");
        }
    }
}
