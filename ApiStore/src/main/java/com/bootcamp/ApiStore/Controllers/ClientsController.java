package com.bootcamp.ApiStore.Controllers;

import com.bootcamp.ApiStore.Model.Clients;
import com.bootcamp.ApiStore.Services.ClientsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

    @Autowired
    private ClientsService cs;

    @GetMapping
    @ApiOperation( value = "Get clients", notes = "Gets all clients", produces = "List<Clients>")
    public ResponseEntity<List<Clients>> getAllClients(){
        return ResponseEntity.status(200).body(cs.getClients());
    }

    @PostMapping
    @ApiOperation(value = "Save client", notes = "Saves a client", produces = "String")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Saved a client", response = String.class),
                    @ApiResponse(code = 400, message = "Failed to save a client", response = String.class)
            }
    )
    public ResponseEntity<String> saveClient(@Valid @RequestBody Clients client){
        if(!cs.saveClient(client)) return ResponseEntity.status(400).body("Failed to save a client");
        return ResponseEntity.status(201).body("saved client");
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Modify client", notes = "Modifies a client(if exists)", produces = "String")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Modified a client", response = String.class),
                    @ApiResponse(code = 300, message = "Failed to modify a client", response = String.class)
            }
    )
    public ResponseEntity<String> modifyClient(@Valid @RequestBody Clients client, @PathVariable("id") int id){
        client.setId(id);
        if(!cs.modifyClient(client)) return ResponseEntity.status(400).body("Failed to modify a client");
        return ResponseEntity.status(201).body("modify client");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete client", notes = "Deletes a client(if exists)", produces = "String")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Deleted a client", response = String.class),
                    @ApiResponse(code = 400, message = "Failed to delete a client", response = String.class)
            }
    )
    public ResponseEntity<String> deleteClient(@PathVariable("id") int id){
        if(!cs.deleteClient(id)) return ResponseEntity.status(400).body("Failed to delete a client");
        return ResponseEntity.status(201).body("Deleted client");
    }
}

