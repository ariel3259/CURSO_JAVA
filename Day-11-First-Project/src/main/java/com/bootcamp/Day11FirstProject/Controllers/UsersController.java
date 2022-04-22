package com.bootcamp.Day11FirstProject.Controllers;

import java.util.List;

import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.Day11FirstProject.Services.UsersService;
import com.bootcamp.Day11FirstProject.Model.Users;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping
	@ApiOperation(value = "Listar usuarios", notes = "listar todos los usuarios", tags = {"users-controller"})
	@ApiResponse(code = 200, message = "Usuarios listados")
	public ResponseEntity<List<Users>> getAllUsers(){
		List<Users> allUsers = usersService.getUsers();
		return ResponseEntity.status(200).body(allUsers);
	}
	
	@PostMapping
	@ApiOperation(value = "Crear usuario", notes = "Crea un usuario", tags = {"users-controller"})
	@ApiResponses( value = {
			@ApiResponse(code = 201, message = "created user", response = String.class),
			@ApiResponse(code = 400, message = "Incomplete data or failed to save a user", response = String.class),
			@ApiResponse(code = 500, message = "Something is wrong", response = String.class)
	})
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
		default:
			return ResponseEntity.status(500).body(message);
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Editar usuario", notes = "Edita un usuario", tags = {"users-controller"})
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Modified an User", response = String.class),
			@ApiResponse(code = 400, message = "Incomplete data or failed to modify a user", response = String.class),
			@ApiResponse(code = 500, message = "Something is wrong", response = String.class)
	})
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
			default:
				return ResponseEntity.status(500).body(message);
		}
	}
	
	 @DeleteMapping("/{dni}")
	 @ApiOperation(value = "Eliminar usuario", notes = "Elimina un usuario", tags = {"users-controller"})
	 @ApiResponses( value = {
			 @ApiResponse( code = 201, message = "Deleted an user", response = String.class),
			 @ApiResponse( code = 400, message = "Failed to delete a user", response = String.class),
			 @ApiResponse( code = 500, message = "Something is wrong", response = String.class)
	 })
	 public ResponseEntity<String> deleteUser(@PathVariable("dni") Integer dni){
		 
		 String message = usersService.deleteUser(dni);
		 
		 switch(message) {
		 case "Deleted an user":
			 return ResponseEntity.status(201).body(message);
		 case "Failed to delete an user":
			 return ResponseEntity.status(400).body(message);
		default:
			 return ResponseEntity.status(500).body(message);
		 }
	 }
		 
} 