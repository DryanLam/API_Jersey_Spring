package com.sample.dl.controller;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Component
@Path("/car")
public class CarController {

    @GET
    @Produces("application/json")
    public Response getBike() {
        Map bike = new HashMap();
        bike.put("name", "Jeep");
        bike.put("type", "Off Road");
        return Response.status(200).entity(bike).build();
    }
}
