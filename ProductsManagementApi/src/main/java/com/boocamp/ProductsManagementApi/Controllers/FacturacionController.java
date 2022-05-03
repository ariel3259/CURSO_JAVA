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

import com.boocamp.ProductsManagementApi.Model.Facturacion;
import com.boocamp.ProductsManagementApi.Services.FacturacionService;

@RestController
@RequestMapping("/api/facturacion")
public class FacturacionController {
	
	@Autowired
	private FacturacionService cs;
	
	@GetMapping
	public ResponseEntity<List<Facturacion>> getAll(){
		List<Facturacion> Facturacion = cs.getAll();
		return ResponseEntity.status(200).body(Facturacion);
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Facturacion client){
		cs.save(client);
		String message = "Saved client";
		return ResponseEntity.status(201).body(message);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody Facturacion client, @PathVariable("id") Long id){
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
	
	@GetMapping("/total/{idClient}")
	public ResponseEntity<Integer> getTotal(@PathVariable("idClient") Long id){
		int total = cs.getTotal(id);
		return ResponseEntity.status(200).body(total);
	}
}
