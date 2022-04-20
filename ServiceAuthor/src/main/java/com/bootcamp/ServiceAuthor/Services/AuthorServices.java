package com.bootcamp.ServiceAuthor.Services;

import com.bootcamp.ServiceAuthor.Model.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServices {
    private List<Author> authors = List.of(new Author[]{
            new Author(1, "George", "Bluth", 2112345),
            new Author(2, "Eve", "Weaver", 445332126),
            new Author(3, "Charles", "Morris", 11345678)
    });

    public List<Author> getAuthors(){
        return authors;
    }

    public Optional<String> getAuthorById(int id){
        return Optional.of(authors.get(id -1).getName() +" "+ authors.get(id - 1).getLastName());
    }

    public String savedAuthor(Author author){
        author.setId(authors.size() + 1);
        authors.add(author);
        return "Created author";
    }
}
