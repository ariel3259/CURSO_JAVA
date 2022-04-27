package com.bootcamp.Users.Controllers;

import com.bootcamp.Users.Model.Users;
import com.bootcamp.Users.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersRepository ur;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(){
    	List<Users> allUsers = (List<Users>) ur.findAll();
        return ResponseEntity.status(200).body(allUsers);
    }
    
    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody Users user){
    	if(user.getUsername().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
    		return ResponseEntity.status(400).body("Incomplete data");
    	}
    	String passwordHashed = passwordEncoder.encode(user.getPassword());
    	user.setPassword(passwordHashed);
    	ur.save(user);
    	return ResponseEntity.status(201).body("Created an user");
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") int id){
    	if(!ur.existsById(id)) return ResponseEntity.status(400).body(null);
    	Users user = ur.findById(id).get();
    	return ResponseEntity.status(200).body(user);
    }
}
