package com.bootcamp.ApiEcommerce.Services;

import com.bootcamp.ApiEcommerce.Model.Articles;
import com.bootcamp.ApiEcommerce.InterfacesRepository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticlesServices {

    @Autowired
    private ArticlesRepository ar;

    public Iterable<Articles> getAllArticles(){
        Iterable<Articles> articles = ar.findAll();
        return articles;
    }

    public String saveArticles(Articles articles){
        ar.save(articles);
        return "Saved article";
    }

    public String modifyArticles(Articles articles, int id){
        articles.setId(id);
        ar.save(articles);
        return "Modified article";
    }

    public String deleeArticles(int id){
        ar.deleteById(id);
        return "Deleted article";
    }
}
