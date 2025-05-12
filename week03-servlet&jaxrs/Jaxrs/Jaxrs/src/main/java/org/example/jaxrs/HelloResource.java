package org.example.jaxrs;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Product;

import java.util.HashMap;
import java.util.Map;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }


    private static HashMap<Integer, Product> products2= new HashMap<>();

    @POST

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addProduct(Product newProduct) {
        products2.put(newProduct.getId(), newProduct);
        return Response.ok("Product added successfully").build();
    }




    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") int id) {
        Product product = products2.get(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Product with ID " + id + " not found.")
                    .build();
        }
        return Response.ok(product).build();
    }


    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteProduct(@PathParam("id") int id) {
        Product product = products2.remove(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Product with ID " + id + " not found.")
                    .build();
        }
        return Response.ok("Product with ID " + id + " has been deleted").build();
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchProduct(@QueryParam("name") String name) {
        for (Map.Entry<Integer, Product> entry : products2.entrySet()) {
            if (entry.getValue().getName().equalsIgnoreCase(name)) {
                return Response.ok(entry.getValue()).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity("No product found with the name: " + name)
                .build();
    }



}