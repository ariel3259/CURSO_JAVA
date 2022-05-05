package com.bootcamp.ApiGames.Model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class GamesList {
	@Getter @Setter
	private List<Games> gameList;
	
	public GamesList() {
		gameList = new ArrayList<Games>();
	}
}
