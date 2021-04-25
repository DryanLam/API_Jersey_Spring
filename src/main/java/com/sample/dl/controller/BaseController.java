package com.sample.dl.controller;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("/")
public class BaseController {

    @GET
    @Produces("application/json")
    @Path("/info")
    public Response appInfo(@HeaderParam("testcase") String testCase) {
        String greet = "WARNING: This ApP is HACKED!!!";
        System.out.println(greet);
        String output = "{'greet': '" + greet + "', 'status': 'hacked'}";
        return Response.status(200).entity(output).build();
    }
}
