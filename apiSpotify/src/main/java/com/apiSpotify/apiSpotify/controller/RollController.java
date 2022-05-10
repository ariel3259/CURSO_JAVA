package com.apiSpotify.apiSpotify.controller;


import com.apiSpotify.apiSpotify.model.Roll;
import com.apiSpotify.apiSpotify.model.Usuario;
import com.apiSpotify.apiSpotify.service.RollService;
import com.apiSpotify.apiSpotify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roll")
public class RollController {

    @Autowired
    private RollService rs;

    @PostMapping
    public void createUser(@RequestBody Roll roll) {
        try {
            rs.saveRoll(roll);
        }catch (Exception e){

        }

    }


    @GetMapping
    public List<Roll> getAll(){
        return rs.getAllRolls();
    }

    @GetMapping("/{name}")
    public Roll getRoll(@PathVariable("name") String name) {
        return rs.getOneRoll(name);
    }

    @DeleteMapping("/{id}")
    public void deleteRoll(@PathVariable("id") int id) {
        rs.deleteRoll(id);
    }
}
