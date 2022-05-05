package com.bootcamp.ApiGames.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.ApiGames.Model.Games;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {
	
}
