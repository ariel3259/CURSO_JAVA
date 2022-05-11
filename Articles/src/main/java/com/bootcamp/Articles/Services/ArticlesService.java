package com.bootcamp.Articles.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.Articles.Model.Articles;
import com.bootcamp.Articles.Repository.ArticlesRepository;

@Service
public class ArticlesService {
	
	@Autowired
	private ArticlesRepository repository;
	
	public List<Articles> getAll(){
		return repository.findAll();
	}
	
	public boolean save(Articles article){
		if(repository.existsByCode(article.getCode())) return false;
		repository.save(article);
		return true;
	}
	
	public boolean update(Articles article) {
		if(!repository.existsById(article.getId())) return false;
		repository.save(article);
		return true;
	}
	
	public boolean delete(long id) {
		if(!repository.existsById(id)) return false;
		repository.deleteById(id);
		return true;
	}
}
