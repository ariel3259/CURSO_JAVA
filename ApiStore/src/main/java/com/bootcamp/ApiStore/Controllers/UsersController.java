package com.bootcamp.ApiStore.Controllers;

import com.bootcamp.ApiStore.Model.Users;
import com.bootcamp.ApiStore.Requests.LoginRequest;
import com.bootcamp.ApiStore.Services.UsersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService us;

    @PostMapping("/register")
    @ApiOperation(value = "Register", notes = "Register an user",  produces = "String")
    @ApiResponses(value = {
            @ApiResponse(code = 201, response = String.class, message = "User created"),
            @ApiResponse(code = 400, response = String.class, message = "Failed to create an user")
    })
    public ResponseEntity<String> register(@Valid @RequestBody Users user){
        if(!us.Register(user)) return ResponseEntity.status(400).body("The user already exists");
        return ResponseEntity.status(201).body("Created user");
    }

    @PostMapping("/auth")
    @ApiOperation(value = "Auth", notes = "Authenticate an user", produces = "String")
    @ApiResponses(value = {
            @ApiResponse(code = 201, response = String.class, message = "Valid user"),
            @ApiResponse(code = 400, response = String.class, message = "Invalid user")
    })
    public ResponseEntity<String> auth(@Valid @RequestBody LoginRequest login){
        if(!us.Auth(login)) return ResponseEntity.status(400).body("Wrong email or password");
        return ResponseEntity.status(201).body("Congratulations");
    }
}
