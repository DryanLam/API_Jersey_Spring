package com.sample.dl.controller;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Component
@Path("/book")
public class BookController {

    @GET
    @Produces("application/json")
    public Response getBook() {
        Map output = new HashMap();
        output.put("total", "3");
        output.put("cost", "2000");
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/register")
    @Produces("application/json")
    public Response getBookRegister() {
        Map book = new HashMap();
        book.put("name", "Code Complete");
        book.put("status", "register");
        return Response.status(200).entity(book).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{oid}")
    public Response getBookId(@PathParam("oid") String oid) {
        Map output = new HashMap();
        output.put("id", oid);
        output.put("name", "White Hat Hacking Ethetic");
        return Response.status(200).entity(output).build();
    }
}
