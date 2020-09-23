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
@Path("/books")
public class BookController {

    public BookController() {

    }

    @GET
    @Produces("application/json")
    public Response getAllBooks() {
        String output = "{'total': '3', 'coast': '2000'}";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/register")
    @Produces("application/json")
    public Response testBookHeader() {
        Map book = new HashMap();
        book.put("name", "Code Complete");
        book.put("status", "register");
        return Response.status(200).entity(book).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{oid}")
    public Response getBook(@PathParam("oid") String oid) {
        String output = "{'id': '" + oid + "', 'name': 'White Hat Hacking Ethetic'}";
        return Response.status(200).entity(output).build();
    }
}
