package com.sample.dl.controller;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("/user")
public class UserController {

    @GET
    @Produces("application/json")
    public Response getUser() {
        String output = "{'name': 'Dryan Lam', 'BU': 'Turing'}";
        return Response.status(200).entity(output).build();
    }
}
