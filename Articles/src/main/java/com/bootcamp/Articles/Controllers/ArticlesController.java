package com.bootcamp.Articles.Controllers;

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

import com.bootcamp.Articles.Model.Articles;
import com.bootcamp.Articles.Services.ArticlesService;

@RestController
@RequestMapping("/api/articles")
public class ArticlesController { 

	@Autowired
	private ArticlesService service;
	
	@GetMapping
	public ResponseEntity<List<Articles>> getALL(){
		return ResponseEntity.status(200).body(service.getAll());
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Articles article){
		if(!service.save(article)) return ResponseEntity.status(400).body("Article already exists");
		return ResponseEntity.status(201).body("Saved article");
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Articles article){
		if(!service.update(article)) return ResponseEntity.status(400).body("Article doesn't eixsts");
		return ResponseEntity.status(200).body("Updated article");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		if(!service.delete(id)) return ResponseEntity.status(400).body("Article doesn't exists");
		return ResponseEntity.status(200).body("Deleted article");
	}
}
