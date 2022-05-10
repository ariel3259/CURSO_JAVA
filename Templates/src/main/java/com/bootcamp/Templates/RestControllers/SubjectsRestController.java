package com.bootcamp.Templates.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.Templates.Model.Subjects;
import com.bootcamp.Templates.Services.SubjectsService;

@RestController
@RequestMapping("/api/subjects")
public class SubjectsRestController {
	
	@Autowired
	private SubjectsService subjectsService;
	
	@GetMapping
	public ResponseEntity<List<Subjects>> getAll(){
		return ResponseEntity.status(200).body(subjectsService.getAllSubjects());
	}

	@GetMapping("/getAll/{pagNum}/{pagSize}")
	public ResponseEntity<Page<Subjects>> getAll(@PathVariable("pagNum") int pagNum, @PathVariable("pagSize") int pagSize){
		return ResponseEntity.status(200).body(subjectsService.getAllSubjects(pagNum, pagSize));
	}
	
	@GetMapping("/getByName/{pagNum}/{pagSize}/{name}")
	public ResponseEntity<Page<Subjects>> getByName(@PathVariable("pagNum") int pagNum, @PathVariable("pagSize") int pagSize, @PathVariable("name") String name){
		return ResponseEntity.status(200).body(subjectsService.getByName(pagNum, pagSize, name));
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Subjects> getById(@PathVariable("id") int id){
		return ResponseEntity.status(200).body(subjectsService.getOne(id));
	}

	@PostMapping
	public ResponseEntity<String> save(@RequestBody Subjects subject){
		if(!subjectsService.saveSubject(subject)) return ResponseEntity.status(400).body("Failed to save a subject");
		return ResponseEntity.status(200).body("Saved subject");
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Subjects subject){
		if(!subjectsService.editSubject(subject)) return ResponseEntity.status(400).body("Failed to update a subject");
		return ResponseEntity.status(200).body("Modified subject");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		if(!subjectsService.deleteSubject(id)) return ResponseEntity.status(400).body("Failed to delete a subject"); 
		return ResponseEntity.status(200).body("Deleted subject");
	}
	
}

