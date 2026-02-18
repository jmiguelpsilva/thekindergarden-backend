package com.thekindergarden.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/child")
public class ChildController {

    @GET
    @Produces("application/json")
    public Response helloFromChild() {
        return Response.ok("Hello from Child!").build();
    }
}
