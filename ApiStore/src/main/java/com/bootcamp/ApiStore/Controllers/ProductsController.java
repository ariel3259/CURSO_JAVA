package com.bootcamp.ApiStore.Controllers;

import com.bootcamp.ApiStore.Model.Products;
import com.bootcamp.ApiStore.Services.ProductsServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsServices ps;

    @GetMapping
    @ApiOperation(value = "Get products", notes = "Get all products", produces = "List<Products>")
    public ResponseEntity<List<Products>> getAllProducts(){
        return ResponseEntity.status(201).body(ps.getProducts());
    }

    @PostMapping
    @ApiOperation(value = "Save product", notes = "Save a product", produces = "String")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Saved product", response = String.class),
            @ApiResponse(code = 400, message = "Failed to save product", response = String.class)
    })
    public ResponseEntity<String> saveProduct(@Valid @RequestBody Products product){
        if(!ps.saveProduct(product)) return ResponseEntity.status(400).body("Failed to save product");
        return ResponseEntity.status(201).body("Saved product");
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Modify product", notes = "Modifies a product(if exists)", produces = "String")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Modified product", response = String.class),
                    @ApiResponse(code = 400, message = "Failed to modify an product", response = String.class)
            }
    )
    public ResponseEntity<String> modifyProduct(@Valid @RequestBody Products product, @PathVariable("id") int id){
        product.setId(id);
        if(!ps.modifyProduct(product)) return ResponseEntity.status(400).body("Failed to modify product");
        return ResponseEntity.status(201).body("Modified product");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete product", notes = "Delete a product(if exists)", produces = "String")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Deleted product", response = String.class),
                    @ApiResponse(code = 400, message = "Failed to delete a product", response = String.class)
            }
    )
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
        if(!ps.deleteProduct(id)) return ResponseEntity.status(400).body("Failed to delete a product");
        return ResponseEntity.status(201).body("Deleted product");
    }
}
