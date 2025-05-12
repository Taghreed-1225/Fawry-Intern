package controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controller.servlet.AddProduct.products;

@WebServlet("/get-product")
public class GetProduct extends HttpServlet {
   // private static List<Product> products = new ArrayList<>();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json");
        String jsonResponse = objectMapper.writeValueAsString(products);
        response.getWriter().write(jsonResponse);

    }
}

