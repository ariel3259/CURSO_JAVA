package com.bootcamp.ApiEcommerce.Adapters;

import com.bootcamp.ApiEcommerce.Model.Articles;
import com.bootcamp.ApiEcommerce.Ports.IPortDelete;
import com.bootcamp.ApiEcommerce.Ports.IPortGet;
import com.bootcamp.ApiEcommerce.Ports.IPortPost;
import com.bootcamp.ApiEcommerce.Ports.IPortUpdate;
import com.bootcamp.ApiEcommerce.Services.ArticlesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
public class ArticlesAdapter
        implements
        IPortGet<Iterable<Articles>>,
        IPortPost<Articles, String>,
        IPortUpdate<Articles, String, Integer>,
        IPortDelete<Integer, String>
{

    @Autowired
    private ArticlesServices ap;

    @GetMapping
    public ResponseEntity<Iterable<Articles>> getElement(){
        Iterable<Articles> articles = ap.getAllArticles();
        return ResponseEntity.status(200).body(articles);
    }

    @PostMapping()
    public ResponseEntity<String> postElement(@RequestBody Articles article){
        if(article.getName().isEmpty() || article.getPrice() == null || article.getStock() == null){
            String error = "Incomplete data";
            return ResponseEntity.status(400).body(error);
        }
        String message = ap.saveArticles(article);
        return ResponseEntity.status(201).body(message);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateElement(@RequestBody Articles article, @PathVariable("id") Integer id){
        if(article.getName().isEmpty() || article.getPrice() == null || article.getStock() == null){
             String error = "Incomplete data";
             return ResponseEntity.status(400).body(error);
        }
        String message = ap.modifyArticles(article, id);
        return ResponseEntity.status(201).body(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteElement(@PathVariable("id") Integer id){
        String message = ap.deleeArticles(id);
        return ResponseEntity.status(201).body(message);
    }
}
