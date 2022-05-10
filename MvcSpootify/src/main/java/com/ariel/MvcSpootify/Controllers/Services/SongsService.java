package com.ariel.MvcSpootify.Controllers.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ariel.MvcSpootify.Model.Songs;
import com.ariel.MvcSpootify.Repository.SongsRepository;

@Service
public class SongsService {
	
	@Autowired
	private SongsRepository repository;
	
	public List<Songs> getAll(){
		return repository.findAll();
	}
	
	public void save(Songs song) {
		repository.save(song);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
}
