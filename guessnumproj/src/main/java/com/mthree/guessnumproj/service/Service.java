/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.guessnumproj.service;
import com.mthree.guessnumproj.dto.*;
import com.mthree.guessnumproj.dao.*;
import java.util.List;
import org.springframework.dao.DataAccessException;
/**
 *
 * @author ArmandoGonzalez
 */
public interface Service {
    
    //generates a new game
    Game startgame();
    
    //starts a new round automatically
    Round guess(int gameId, String guess) throws DataAccessException;
    
    //return exact match value 
    int getExactMatchVal(String guess, Game game);
    
    //return partial match value
    int getPartialMatchVal(String guess, Game game);
    
    //determine if game answer or guess is valid format
    boolean isNumStrValid(String numStr);
    
    //add player three character initials
    String addPlayerInitials(String playerInitials, Game game);
    
    //check if player wins
    boolean isPlayerWin(Game game);
    
    //get game
    Game getGame(int gameId) throws DataAccessException;
    
    //get all games
    List<Game> getAllGames() throws DataAccessException;
    
    //get Rounds from a game
    List<Round> getRounds(int gameId) throws DataAccessException;
    
    // use this method to fetch out the gameId and user guess from dao
    Round guess(Round r);
}
