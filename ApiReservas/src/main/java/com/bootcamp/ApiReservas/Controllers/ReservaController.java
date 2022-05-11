package com.bootcamp.ApiReservas.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.ApiReservas.Model.Reserva;
import com.bootcamp.ApiReservas.Services.ReservaService;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {
	
	@Autowired
	private ReservaService service;
	 
	
	@GetMapping
	public ResponseEntity<List<Reserva>> getAll(){
		return ResponseEntity.status(200).body(service.getAll());
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Reserva reserva){
		String message =  "Saved reserva";
		int status = 201;
		service.save(reserva);
		return ResponseEntity.status(status).body(message);
	}
	

	@PutMapping
	public ResponseEntity<String> update(@RequestBody Reserva reserva){
		String message =  "Modified reserva";
		int status = 200;
		service.save(reserva);
		return ResponseEntity.status(status).body(message);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		String message = "Delete reserva";
		service.delete(id);
		return ResponseEntity.status(200).body(message);
	}
	
}
