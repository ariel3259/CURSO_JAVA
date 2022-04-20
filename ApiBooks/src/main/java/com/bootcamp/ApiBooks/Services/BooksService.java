package com.bootcamp.ApiBooks.Services;

import com.bootcamp.ApiBooks.Models.Books;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    List<Books> books;

    public BooksService(){
        books = new LinkedList<>();
        books.add( new Books(1, "libro generico 1", "descripcion de libro generico 1", null));
        books.add( new Books(2, "generic book 2", "generic book 2's description", null));
        books.add(  new Books(3, "generic book 3", "generic book 3 description", null));
    }
   public List<Books> getBooks(){
       return books;
   }

   public String saveBook(Books book){
       book.setId(books.size() +1);
       books.add(book);
       return "Book saved";
   }

   public Optional<Books> getBook(int id){
       return Optional.ofNullable(books.get(id - 1));
   }

   public String addAnAuthor(int bookId, int authorId)  {

      try{
          URL request = new URL("http://localhost:8000/api/author/get/one/author/"+authorId);
          HttpURLConnection requestConnection = (HttpURLConnection) request.openConnection();
          requestConnection.connect();
          String fullName = requestConnection.getResponseMessage();
          books.get(bookId - 1).setAuthor(fullName);
        return "Author added into a book";
      }catch (Exception e){
          String error = e.getMessage();
          System.out.println(error);
          return "Something is wrong";
      }
   }
}
