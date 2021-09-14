/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.guessnumproj.service;
import com.mthree.guessnumproj.dto.*;
import java.util.List;
/**
 *
 * @author ArmandoGonzalez
 */
public interface Service {
    
    //generates a new game
    Game startgame();
    
    //starts a new round automatically
    Round guess(Game game, String guess);
    
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
    Game getGame(int gameId);
    
    //get Rounds from a game
    List<Round> getRounds(int gameId);
}
