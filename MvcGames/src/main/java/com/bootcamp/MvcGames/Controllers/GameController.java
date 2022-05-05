package com.bootcamp.MvcGames.Controllers;

import com.bootcamp.MvcGames.Model.GameList;
import com.bootcamp.MvcGames.Model.Games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class GameController {

    @Autowired
    RestTemplate r;

    @GetMapping("/")
    public String main(Model model){
        GameList gameList = r.getForObject("http://localhost:8000/api/games", GameList.class);
        model.addAttribute("games",gameList.getGameList());
        return "index";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id")long id, Model model){
        ResponseEntity<Games> response = r.getForEntity("http://localhost:8000/api/games/" + id, Games.class);
        
        model.addAttribute("game", response.getBody());
        return "update_game";
    }
    
    @GetMapping("/create")
    public String showCreateGame(Model model) {
    	model.addAttribute("game", new Games());
    	return "create_game";
    }

    @PostMapping("/create")
    public String postGame(RedirectAttributes redirect,@Validated @ModelAttribute Games game, BindingResult result) {
        if(result.hasErrors()) return "/";
        r.postForEntity("http://localhost:8000/api/games", game, String.class);
        return "redirect:/";
    }

    @PostMapping("/{id}")
    public String putGame(@ModelAttribute @Validated Games game, BindingResult result){
        if(result.hasErrors()) return "/";
        r.put("http://localhost:8000/api/games", game);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteGame(@PathVariable("id")long id){
    r.delete("http://localhost:8000/api/games/"+id);
    return"redirect:/";
    }
}
