package com.ariel.Controllers;

import com.ariel.Model.Users;
import com.ariel.Services.UsersService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    public List<Users> getUsers(){
        List<Users> allUsers = usersService.getUsers();
        return allUsers;
    }

    @GET
    @Path("/get_user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Users getUser(@PathParam("id") int id){
        Users user = usersService.getUser(id);
        return user;
    }

    @POST
    @Path("/save_user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/text")
    public String saveUser(Users user){
        usersService.saveUser(user);
        return "user saved";
    }

    @PUT
    @Path("/update_user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/text")
    public String updateUser(Users user){
        usersService.updateUser(user);
        return "user updated";
    }

    @DELETE
    @Path("/delete_user/{id}")
    @Produces("application/text")
    public String deleteUser(@PathParam("id") int id){
        usersService.deleteUser(id);
        return "user deleted";
    }

}
