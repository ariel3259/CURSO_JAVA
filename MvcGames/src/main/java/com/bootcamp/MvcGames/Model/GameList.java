package com.bootcamp.MvcGames.Model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class GameList {
    
    @Setter
    @Getter
    private List<Games> gameList;

    public GameList() {
        gameList = new ArrayList<Games>();
    }
}