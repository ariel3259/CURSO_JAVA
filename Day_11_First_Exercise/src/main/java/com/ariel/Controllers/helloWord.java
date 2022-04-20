package com.ariel.Controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloWord")
public class helloWord {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting(){
        String greetings = "Hi word";
        return greetings;
    }
}