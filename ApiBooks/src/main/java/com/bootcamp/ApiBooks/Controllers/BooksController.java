package com.bootcamp.ApiBooks.Controllers;

import com.bootcamp.ApiBooks.Models.Books;
import com.bootcamp.ApiBooks.Services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping("/get/all/books")
    public ResponseEntity<List<Books>> getAllBooks(){
        List<Books> allBooks = booksService.getBooks();
        
        return ResponseEntity.status(201).body(allBooks);
    }

    @GetMapping("/get/one/book/{id}")
    public ResponseEntity<Books> getOneBook(@PathVariable("id") Integer id){
        if(id == null){
            return ResponseEntity.status(400).body(null);
        }

        Optional<Books> book = booksService.getBook(id);

        if(book.isEmpty()){
            return ResponseEntity.status(400).body(null);
        }

        return ResponseEntity.status(201).body(book.get());
    }

    @PostMapping("/save/one/book")
    public ResponseEntity<String> saveBook(@RequestBody Books book){
        if(book.getName() == null || book.getDescription() == null){
            return ResponseEntity.status(400).body("Incomplete data");
        }
        String response = booksService.saveBook(book);

        return ResponseEntity.status(201).body(response);
    }

    @PostMapping("/{idBook}/{idAuthor}")
    public ResponseEntity<String> AddAnAuthorToABook(@PathVariable("idBook") Integer idBook, @PathVariable("idAuthor") Integer idAuthor){
        if(idBook == null || idAuthor == null ){
            return ResponseEntity.status(400).body("Incomplete data");
        }
        String response = booksService.addAnAuthor(idBook, idAuthor);

        return ResponseEntity.status(201).body(response);
    }

}
