package com.bootcamp.ApiUsers.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.ApiUsers.Model.Users;
import com.bootcamp.ApiUsers.Model.UsersList;
import com.bootcamp.ApiUsers.Services.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UsersService service;
	
	@GetMapping
	public ResponseEntity<UsersList> getAll(){
		UsersList userList = new UsersList();
		userList.setUsersList(service.getAll());
		return ResponseEntity.status(200).body(userList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getOne(@PathVariable("id") long id){
		Users user = service.getOne(id);
		return ResponseEntity.status(200).body(user);
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Users user){
		if(!service.save(user)) return ResponseEntity.status(400).body("The user already exists");
		return ResponseEntity.status(201).body("Saved user");
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Users user){
		if(!service.update(user)) return ResponseEntity.status(400).body("The user doesn't exists");
		return ResponseEntity.status(200).body("Updated user");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		if(!service.delete(id)) return ResponseEntity.status(400).body("The user doesn't exists");
		return ResponseEntity.status(200).body("User deleted");
	}
}
