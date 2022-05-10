package com.bootcamp.Templates.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.Templates.Model.Register;
import com.bootcamp.Templates.Requests.RegisterRequest;
import com.bootcamp.Templates.Services.RegisterService;



@RestController
@RequestMapping("/api/registers")
public class RegistersRestController {

	@Autowired
	private RegisterService service;
	
	@GetMapping
	public ResponseEntity<List<Register>> getAll(){
		return ResponseEntity.status(200).body(service.getAll());
	}
	
	@GetMapping("/getAll/{pagNum}/{pagSize}")
	public ResponseEntity<Page<Register>> getAll(@PathVariable("pagNum") int pagNum, @PathVariable("pagSize") int pagSize){
		return ResponseEntity.status(200).body(service.getAll(pagNum, pagSize));
	}
	
	@GetMapping("/getBySubjectName/{pagNum}/{pagSize}/{subjectName}")
	public ResponseEntity<Page<Register>> getBySubjectName(@PathVariable("pagNum") int pagNum, @PathVariable("pagSize") int pagSize, @PathVariable("subjectName") String subjectName){
		return ResponseEntity.status(200).body(service.getBySubjectPage(pagNum, pagSize, subjectName));
	}
	
	@GetMapping("/getByStudentName/{pagNum}/{pagSize}/{subjectName}")
	public ResponseEntity<Page<Register>> getByStudentName(@PathVariable("pagNum") int pagNum, @PathVariable("pagSize") int pagSize, @PathVariable("subjectName") String studentName){
		return ResponseEntity.status(200).body(service.getByStudentPage(pagNum, pagSize, studentName));
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody RegisterRequest register){
		if(!service.save(register.getCodeSubject(), register.getDniStudent())) return ResponseEntity.status(400).body("Failed to save a register");
		return ResponseEntity.status(200).body("Saved register");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		if(!service.delete(id)) return ResponseEntity.status(400).body("Failed to delete student");
		return ResponseEntity.status(200).body("Dekete student");
	}
}
