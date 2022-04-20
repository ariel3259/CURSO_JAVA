package com.bootcamp.ServiceAuthor.Controllers;

import com.bootcamp.ServiceAuthor.Model.Author;
import com.bootcamp.ServiceAuthor.Services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorServices authorServices;

    @GetMapping("get/all/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> allAuthors = authorServices.getAuthors();
        return ResponseEntity.status(201).body(allAuthors);
    }

    @GetMapping("get/one/author/{id}")
    public ResponseEntity<String> getOneAuthor(@PathVariable("id") Integer id){
        if(id == null){
            return ResponseEntity.status(400).body(null);
        }

        Optional<String> author = authorServices.getAuthorById(id);

        if(author.isEmpty()){
            return ResponseEntity.status(400).body(null);
        }

    return ResponseEntity.status(201).body(author.get());
    }
}
