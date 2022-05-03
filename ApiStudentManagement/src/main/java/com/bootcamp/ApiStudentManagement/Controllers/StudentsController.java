package com.bootcamp.ApiStudentManagement.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.ApiStudentManagement.Model.Students;
import com.bootcamp.ApiStudentManagement.Services.StudentsService;

@RestController
@RequestMapping
public class StudentsController {
	
	@Autowired
	private StudentsService stse;
	
	@GetMapping
	public ResponseEntity<List<Students>> getAllStudents(){
		List<Students> students = stse.getAllStudents();
		return ResponseEntity.status(200).body(students);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneStudent(@PathVariable("id") int id){
		Students student = stse.getOneStudent(id);
		if(student == null) return ResponseEntity.status(400).body("{}");
		return ResponseEntity.status(200).body(student);
	}
	
	@PostMapping()
	public ResponseEntity<String> saveStudent(@Valid @RequestBody Students student){
		if(!stse.saveStudent(student)) return ResponseEntity.status(400).body("Failed to save a student");
		return ResponseEntity.status(200).body("Saved user");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> modifyStudent(@Valid @RequestBody Students student, @PathVariable("id") int id){
		student.setId(id);
		if(!stse.modifyStudent(student)) return ResponseEntity.status(400).body("Failed to modify an user");
		return ResponseEntity.status(200).body("Modified student");
	}
	
	@PatchMapping("/name/{name}/{id}")
	public ResponseEntity<String> modifyName(@PathVariable("name") String name, @PathVariable("id") String id){
		if(name.isEmpty() || id.isEmpty()) return ResponseEntity.status(400).body("Incomplete data");
		if(!stse.modifyName(name, Integer.parseInt(id))) return ResponseEntity.status(400).body("Student doesn't exists");
		return ResponseEntity.status(200).body(" Modified student name");
	}
	
	@PatchMapping("/username/{username}/{id}")
	public ResponseEntity<String> modifyUsername(@PathVariable("username") String username, @PathVariable("id") String id){
		if(username.isEmpty() || id.isEmpty()) return ResponseEntity.status(400).body("Incomplete data");
		if(!stse.modifyUsername(username, Integer.parseInt(id))) return ResponseEntity.status(400).body("Student doesn't exists");
		return ResponseEntity.status(200).body(" Modified student username");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
		if(stse.deleteStudent(id)) return ResponseEntity.status(400).body("Failed to modify an user");
		return ResponseEntity.status(200).body("Deleted student");
	}
}
