package controller.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controller.servlet.AddProduct.products;

@WebServlet("/delete-product")
public class DeleteProduct extends HttpServlet {


    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String idParam = request.getParameter("id");

        if (idParam == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Missing 'id' parameter");
            return;
        }

        int id = Integer.parseInt(idParam);


        boolean removed=false;

        if (products.containsKey(id)) {
            products.remove(id);
            removed = true;
        }

        if (removed) {
            response.getWriter().write("Product deleted successfully");
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("Product not found");
        }
    }
}
