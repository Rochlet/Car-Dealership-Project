/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.guessnumproj.dto;
import java.time.LocalDateTime;
/**
 *
 * @author ArmandoGonzalez
 */
public class Round {
    private final LocalDateTime guessTime;
    private int exactMatchCount;
    private int partialMatch;
    private int playerGuess;
    
    //guess time is set when round is created
    public Round(LocalDateTime guessTime) {
        this.guessTime = guessTime;
    }

    //only getter for guess time
    public LocalDateTime getGuessTime() {
        return guessTime;
    }
    
    //setters and getters
    public int getExactMatchCount() {
        return exactMatchCount;
    }

    public void setExactMatchCount(int exactMatchCount) {
        this.exactMatchCount = exactMatchCount;
    }

    public int getPartialMatch() {
        return partialMatch;
    }

    public void setPartialMatch(int partialMatch) {
        this.partialMatch = partialMatch;
    }

    public int getPlayerGuess() {
        return playerGuess;
    }

    public void setPlayerGuess(int playerGuess) {
        this.playerGuess = playerGuess;
    }

}
