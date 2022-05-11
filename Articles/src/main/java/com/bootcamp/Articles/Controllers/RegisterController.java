package com.bootcamp.Articles.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.Articles.Model.Users;
import com.bootcamp.Articles.Services.UsersService;

@RestController
@RequestMapping("/register")
@CrossOrigin
public class RegisterController {

	@Autowired
	private UsersService service;
	
	@PostMapping
	public ResponseEntity<String> register(@RequestBody Users user){
		if(!service.register(user)) return ResponseEntity.status(400).body("The user already exists");
		return ResponseEntity.status(200).body("Users register");
	}
}
