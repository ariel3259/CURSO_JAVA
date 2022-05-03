package com.boocamp.ProductsManagementApi.Controllers;

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

import com.boocamp.ProductsManagementApi.Model.Products;
import com.boocamp.ProductsManagementApi.Services.ProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	@Autowired
	private ProductsService cs;
	
	@GetMapping
	public ResponseEntity<List<Products>> getAll(){
		List<Products> Products = cs.getAll();
		return ResponseEntity.status(200).body(Products);
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Products client){
		cs.save(client);
		String message = "Saved client";
		return ResponseEntity.status(201).body(message);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody Products client, @PathVariable("id") Long id){
		client.setId(id);
		cs.update(client);
		String message = "Modify client";
		return ResponseEntity.status(200).body(message);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		cs.delete(id);
		String message = "Deleted client";
		return ResponseEntity.status(200).body(message);
	}
}
