package com.mthree.guessnumproj.controller;

import com.mthree.guessnumproj.dto.Game;
import com.mthree.guessnumproj.dto.Round;
import com.mthree.guessnumproj.service.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eric
 */
@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    Service service;
    
    /*
        "begin" - POST – Starts a game, generates an answer, and sets the 
                  correct status. Should return a 201 CREATED message as 
                  well as the created gameId.
    */
    @PostMapping("/begin")
    public Game createNewGame(){
        return service.startgame();
    }
    
    /*
        "guess" – POST – Makes a guess by passing the guess and gameId
                  in as JSON. The program must calculate the results of the
                  guess and mark the game finished if the guess is correct.
                  It returns the Round object with the results filled in.
    */
    @PostMapping("/guess")
    public Round makeAGuess(@RequestBody Round round){
        return service.guess(round);
    }
    // round 
    
            // conn3ct 
    /*
        "game" –  GET – Returns a list of all games. Be sure in-progress
          games do not display their answer.
    
    */
    
    @GetMapping("/game")
    public List<Game> getAllGames() {
        return service.getAllGames();
    }
    
    /*
        "game/{gameId}" - GET – Returns a specific game based on ID. Be 
                  sure in-progress games do not display their answer.
    */
        
    @GetMapping("/rounds/{game_id}")
    public List<Round> getRoundsForGame(@PathVariable("game_id") int gameId) {
        return service.getRounds(gameId);
    }
}
