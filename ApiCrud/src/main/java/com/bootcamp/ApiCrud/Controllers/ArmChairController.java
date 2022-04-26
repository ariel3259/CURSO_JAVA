package com.bootcamp.ApiCrud.Controllers;

import com.bootcamp.ApiCrud.Entity.ArmChairEntity;
import com.bootcamp.ApiCrud.Services.ArmChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArmChairController {

    @Autowired
    private ArmChairService acs;

    @GetMapping
    public ResponseEntity<List<ArmChairEntity>> getArmChairs(){
        List<ArmChairEntity> armChairs = acs.getAllArmChairs();
        return ResponseEntity.status(200).body(armChairs);
    }

    @PostMapping
    public ResponseEntity<String> saveArmChair(@RequestBody ArmChairEntity armChair){
        if(!acs.saveArmChair(armChair)) return ResponseEntity.status(400).body("Failed to create a armchair");
        return ResponseEntity.status(201).body("Created armchair");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putArmChair(@RequestBody ArmChairEntity armChair, @PathVariable("id") int id){
        armChair.setId(id);
        if(!acs.updateArmChair(armChair)) return ResponseEntity.status(400).body("Failed to update a armchair");
        return ResponseEntity.status(200).body("Update armchair");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArmChair(@PathVariable("id") int id){
        if(!acs.deleteArmChair(id)) return ResponseEntity.status(400).body("Failed to delete a armchair");
        return ResponseEntity.status(200).body("Delete armchair");
    }

}
