package com.bootcamp.ApiCrud.Controllers;

import com.bootcamp.ApiCrud.Entity.FurnitureEntity;
import com.bootcamp.ApiCrud.Services.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/furniture")
public class FurnitureController {

    @Autowired
    private FurnitureService fs;

    @GetMapping
    public ResponseEntity<List<FurnitureEntity>> getAllFurnitures(){
        List<FurnitureEntity> furnitures = fs.readAllFurnitures();
        return ResponseEntity.status(201).body(furnitures);
    }

    @PostMapping
    public ResponseEntity<String> saveFurniture(@RequestBody FurnitureEntity furniture){
        if(!fs.createFurniture(furniture)) return ResponseEntity.status(400).body("Failed to save a furniture");
        return ResponseEntity.status(201).body("Saved furniture");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modifyFurniture(@RequestBody FurnitureEntity furniture, @PathVariable("id") int id){
        furniture.setId(id);
        if(!fs.updateFurniture(furniture)) return ResponseEntity.status(400).body("Failed to update a furniture");
        return ResponseEntity.status(200).body("Modified a furniture");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFurniture(@PathVariable("id") int id){
        if(!fs.deleteFurniture(id)) return ResponseEntity.status(400).body("Failed to delete a furniture");
        return ResponseEntity.status(200).body("Deleted a furniture");
    }
}
