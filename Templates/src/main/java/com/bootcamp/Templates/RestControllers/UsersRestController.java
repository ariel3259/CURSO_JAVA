package com.bootcamp.Templates.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.Templates.Email.Email;
import com.bootcamp.Templates.Email.EmailServerTemplate;
import com.bootcamp.Templates.Email.IEmail;
import com.bootcamp.Templates.Model.Users;
import com.bootcamp.Templates.Services.UsersService;

@RestController
@RequestMapping(path = "/api/users")
public class UsersRestController {
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private IEmail email;
	
	@Autowired
	private EmailServerTemplate template;
	
	@GetMapping
	public ResponseEntity<List<Users>> getAll(){
		return ResponseEntity.status(200).body(userService.getAll());
	}
	
	@GetMapping("/getAll/{pagNum}/{pagSize}")
	public ResponseEntity<Page<Users>> getAllByPagination(@PathVariable("pagNum") int pagNum, @PathVariable("pagSize") int pagSize){
		return ResponseEntity.status(200).body(userService.getAll(pagNum, pagSize));
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Users> getOneUser(@PathVariable("id") int id){
		return ResponseEntity.status(200).body(userService.getOne(id));
	}
	
	@Transactional
	@PostMapping("/email")
	public ResponseEntity<String> sendEmail(@RequestBody Email email) {
		if(!this.email.sendEmail(email)) return ResponseEntity.status(400).body("Failed to send email");
		else return ResponseEntity.status(200).body("Email sended");
	}
	
	@GetMapping("/email/{id}")
	public ResponseEntity<String> sendEmail(@PathVariable("id") int id){
		Users user = userService.getOne(id);
		if(user == null) return ResponseEntity.status(400).body("User doesn't exists");
		if(!template.sendEmail(user)) return ResponseEntity.status(400).body("Failed to send email");
		else return ResponseEntity.status(200).body("Email sended");
	}
	
	@PostMapping
	public ResponseEntity<String> save(@Validated @RequestBody Users user){
		if(!userService.save(user)) return ResponseEntity.status(400).body("Failed to save a user");
		return ResponseEntity.status(201).body("Created a user");
	}
	
	@PutMapping
	public ResponseEntity<String> update(@Validated @RequestBody Users user){
		if(!userService.update(user)) return ResponseEntity.status(400).body("Failed to update a user");
		return ResponseEntity.status(200).body("Updated a user");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		if(!userService.delete(id)) return ResponseEntity.status(400).body("Failed to delete a user");
		return ResponseEntity.status(200).body("Deleted a user"); 
	}

}
