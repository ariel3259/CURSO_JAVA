package com.bootcamp.ApiGames.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.ApiGames.Model.Games;
import com.bootcamp.ApiGames.Model.GamesList;
import com.bootcamp.ApiGames.Repositories.GamesRepository;

@Service
@Transactional
public class GamesService {
	
	@Autowired
	private GamesRepository repository;
	
	public GamesList getAll() {
		GamesList gameList = new GamesList();
		gameList.setGameList(repository.findAll());
		return gameList;
	}
	
	public Games getOne(long id) {
		return repository.findById(id).get();
	}
	
	public void save(Games game) {
		repository.save(game);
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}
}
