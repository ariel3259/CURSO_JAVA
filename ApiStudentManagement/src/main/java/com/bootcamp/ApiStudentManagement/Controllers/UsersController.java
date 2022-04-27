package com.bootcamp.ApiStudentManagement.Controllers;

import java.util.List;

import javax.validation.Valid;

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
import com.bootcamp.ApiStudentManagement.Model.Users;
import com.bootcamp.ApiStudentManagement.Services.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UsersService us;
	
	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers(){
		List<Users> allUsers = us.getAllUses();
		return ResponseEntity.status(200).body(allUsers);
	}
	
	@PostMapping
	public ResponseEntity<String> saveUser(@Valid @RequestBody Users user){
		if(!us.saveUser(user)) return ResponseEntity.status(400).body("Failed to save an user");
		return ResponseEntity.status(201).body("Created user");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@Valid @RequestBody Users user, @PathVariable("id") int id){
		if(!us.editUser(user)) return ResponseEntity.status(400).body("Failed to modify an user");
		user.setId(id);
		return ResponseEntity.status(200).body("Modified user");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
		if(!us.deleteUser(id)) return ResponseEntity.status(400).body("Failed to delete an user");
		return ResponseEntity.status(200).body("Deleted user");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") int id){
		Users user = us.getOneUser(id);
		if(user == null) return ResponseEntity.status(200).body("{}");
		return ResponseEntity.status(200).body(user);
	}
}
