package com.bootcamp.Day11FirstProject.Controllers;

import com.bootcamp.Day11FirstProject.Requests.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

   @Autowired


    @PostMapping("/login")
    public ResponseEntity<?> auth(@Valid @RequestBody LoginRequest loginRequest){

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(){

    }
}
