package controller.servlet;

import model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@WebServlet("/add-product")
public class AddProduct extends HttpServlet {
    protected static HashMap<Integer,Product> products = new HashMap<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {



        // convert from json to object

        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = request.getInputStream();

        // convert from json to object
        Product newProduct = objectMapper.readValue(inputStream, Product.class);
        products.put(newProduct.getId(),newProduct);

        response.setContentType("text/plain");
        response.getWriter().write("Product added successfully");


    }
}
