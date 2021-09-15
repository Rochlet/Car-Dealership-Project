package com.mthree.guessnumproj.controller;

import com.mthree.guessnumproj.dto.Game;
import com.mthree.guessnumproj.dto.Round;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mthree.guessnumproj.service.Service_;
import org.springframework.http.MediaType;


/**
 *
 * @author Eric
 */
@RestController
@RequestMapping("/api")

public class Controller {
    @Autowired
    Service_ service;

    @GetMapping("/begin")
    public Game createNewGame(){
        return service.startgame();
    }
  
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE},
            path = "/guess")
    public Round makeAGuess(@RequestBody Round round){
        return service.guess(round);
    }

    @GetMapping("/game")
    public List<Game> getAllGames() {
        return service.getAllGames();
    }
    @GetMapping("/game/{game_id}")
    public Game getGameById(@PathVariable("game_id") int gameId) {
        return service.getGame(gameId);
    }
    
    @GetMapping("/rounds/{game_id}")
    public List<Round> getRoundsForGame(@PathVariable("game_id") int gameId) {
        return service.getRounds(gameId);
    }
}
