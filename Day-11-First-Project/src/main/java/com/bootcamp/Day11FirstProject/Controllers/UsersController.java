package com.bootcamp.Day11FirstProject.Controllers;

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
import com.bootcamp.Day11FirstProject.Services.UsersService;
import com.bootcamp.Day11FirstProject.Model.Users;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers(){
		List<Users> allUsers = usersService.getUsers();
		return ResponseEntity.status(200).body(allUsers);
	}
	
	@PostMapping
	public ResponseEntity<String> saveUser(@RequestBody Users user){
		if(user.getLastName().isEmpty() || user.getName().isEmpty() || user.getDni().equals(null)) {
			return ResponseEntity.status(400).body("Incomplete data");
		}
		String message = usersService.saveUser(user);
		
		switch(message) {
		case "Added an user":
			return ResponseEntity.status(201).body(message);
		case "Failed to save an user":
			return ResponseEntity.status(400).body(message);
		case "Something is wrong": 
			return ResponseEntity.status(500).body(message);		
		default: 
			return ResponseEntity.status(502).body(null);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@RequestBody Users user, @PathVariable("id") int id){
		if(user.getName().isEmpty() || user.getLastName().isEmpty() || user.getDni() == null ){
			return ResponseEntity.status(400).body("Incomplete data");
		}
		user.setId(id);
		String message = usersService.modifyUser(user);
	
		switch(message) {
		case "Modified an user":
			return ResponseEntity.status(201).body(message);
		case "Failed to modify an user":
			return ResponseEntity.status(400).body(message);
		case "Something is wrong": 
			return ResponseEntity.status(500).body(message);
		default:
			return ResponseEntity.status(502).body(null);
		}
	}
	
	 @DeleteMapping("/{dni}")
	 public ResponseEntity<String> deleteUser(@PathVariable("dni") Integer dni){
		 
		 String message = usersService.deleteUser(dni);
		 
		 switch(message) {
		 case "Deleted an user":
			 return ResponseEntity.status(201).body(message);
		 case "Failed to delete an user":
			 return ResponseEntity.status(400).body(message);
		 case "Something is wrong":
			 return ResponseEntity.status(500).body(message);
		 default: 
			 return ResponseEntity.status(502).body(null);
		 }
	 }
		 
} 