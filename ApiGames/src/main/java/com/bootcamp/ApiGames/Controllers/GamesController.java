package com.bootcamp.ApiGames.Controllers;

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

import com.bootcamp.ApiGames.Model.Games;
import com.bootcamp.ApiGames.Model.GamesList;
import com.bootcamp.ApiGames.Services.GamesService;

@RestController
@RequestMapping("/api/games")
public class GamesController {

	@Autowired
	private GamesService service;
	
	@GetMapping
	public ResponseEntity<GamesList> getAll(){
		return ResponseEntity.status(200).body(service.getAll());
	}
	
	@PostMapping
	public ResponseEntity<String> save( @RequestBody Games game, BindingResult result){
		if(game.isEmpty()) return ResponseEntity.status(400).body("Incomplete data") ;
		service.save(game);
		return ResponseEntity.status(201).body("Saved game");
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Games game){
		if(game.isEmpty() || game.getId() == 0) return ResponseEntity.status(400).body("Incomplete data") ;
		service.save(game);
		return ResponseEntity.status(200).body("Updated game");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		service.delete(id);
		return ResponseEntity.status(200).body("Deleted game");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Games> getOne(@PathVariable("id") long id){
		Games game = service.getOne(id);
		return ResponseEntity.status(200).body(game);
	}
}
