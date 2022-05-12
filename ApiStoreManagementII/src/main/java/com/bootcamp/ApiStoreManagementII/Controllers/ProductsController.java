package com.bootcamp.ApiStoreManagementII.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.ApiStoreManagementII.Model.Products;
import com.bootcamp.ApiStoreManagementII.Services.ProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	@Autowired
	private ProductsService service;
	
	@GetMapping
	public ResponseEntity<List<Products>> getAll(){
		return ResponseEntity.status(200).body(service.getAll());
	}
	
	@PostMapping
	public ResponseEntity<String> save(@Validated @RequestBody Products product, BindingResult result){
		if(result.hasErrors()) return ResponseEntity.status(400).body("Incomplete data");
		if(!service.save(product)) return ResponseEntity.status(400).body("The product already exists");
		return ResponseEntity.status(201).body("Created product");
	}
	
	@PutMapping
	public ResponseEntity<String> update(@Validated @RequestBody Products product, BindingResult result){
		if(result.hasErrors()) return ResponseEntity.status(400).body("Incomplete data");
		if(!service.update(product)) return ResponseEntity.status(400).body("The product doesn't exists");
		return ResponseEntity.status(200).body("Updated product");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		if(!service.delete(id)) return ResponseEntity.status(400).body("The product doesn't exists");
		return ResponseEntity.status(200).body("Deleted product");
	}
}
