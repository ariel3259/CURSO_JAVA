package com.ariel.Controllers;

import com.ariel.Model.Users;
import com.ariel.Services.UsersService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UsersController {

    private UsersService usersService;

    public UsersController(){
        usersService = new UsersService();
    }

    @GET
    @Path("/get_users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
        List<Users> allUsers = usersService.getUsers();
        return Response.status(201).entity(allUsers).build();
    }

    @GET
    @Path("/get_user/{id}")
    @Produces("application/*")
    public Response getUser(@PathParam("id") Integer id){
        if(id == null){
            String error = "Incomplete data";
            return Response.status(400).entity(error).build();
        }
        Users user = usersService.getUser(id);
        return Response.status(201).entity(user).build();
    }

    @POST
    @Path("/save_user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response saveUser(Users user){
        if(user.getName() == null || user.getLastName() == null || user.getDni() == null){
            String error = "Incomplete data";
            return Response.status(400).entity(error).build();
        }
        usersService.saveUser(user);
        return Response.status(Response.Status.ACCEPTED).entity("Saved person").build();
    }

    @PUT
    @Path("/update_user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateUser(Users user){
        if(user.getName() == null || user.getLastName() == null || user.getDni() == null || user.getId() == null){
            String error = "Incomplete data";
            return Response.status(400).entity(error).build();
        }
        usersService.updateUser(user);
        return Response.status(201).entity("user updated").build();
    }

    @DELETE
    @Path("/delete_user/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUser(@PathParam("id") Integer id){
        if(id == null){
            String error = "Incomplete data";
            return Response.status(400).entity(error).build();
        }
        usersService.deleteUser(id);
        return Response.status(201).entity("user deleted").build();
    }

}
