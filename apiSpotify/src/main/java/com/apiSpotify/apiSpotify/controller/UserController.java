package com.apiSpotify.apiSpotify.controller;

import com.apiSpotify.apiSpotify.model.Usuario;
import com.apiSpotify.apiSpotify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService us;

        @PostMapping
        public void createUser(@RequestBody Usuario user) {
            try {
                us.saveUser(user);
            }catch (Exception e){

            }

        }


    @GetMapping
    public List<Usuario> getAll(){
        return us.getAllUsers();
    }

    @GetMapping("/{username}")
    public Usuario getUser(@PathVariable("username") String username) {
        return us.getOneUser(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        us.deleteUser(id);
    }
}
