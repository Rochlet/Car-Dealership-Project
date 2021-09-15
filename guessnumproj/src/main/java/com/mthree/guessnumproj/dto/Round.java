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

    private LocalDateTime guessTime;
    private int exactMatchCount;
    private int partialMatch;
    private String playerGuess;
    private int roundId;
    private int gameId;
    private int playerGuessCount;

    public Round() {
        
    }

    public int getPlayerGuessCount() {
        return playerGuessCount;
    }

    public void setPlayerGuessCount(int playerGuessCount) {
        this.playerGuessCount = playerGuessCount;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    //guess time is set when round is created
    public Round(LocalDateTime guessTime) {
        this.guessTime = guessTime;
    }

    //only getter for guess time
    public LocalDateTime getGuessTime() {
        return guessTime;
    }

    public void setGuessTime(LocalDateTime guessTime) {
       this.guessTime = guessTime;
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

    public String getPlayerGuess() {
        return playerGuess;
    }

    public void setPlayerGuess(String playerGuess) {
        this.playerGuess = playerGuess;
    }

    @Override
    public String toString() {
        return "Round{" + "guessTime=" + guessTime + ", exactMatchCount=" + exactMatchCount + ", partialMatch=" + partialMatch + ", playerGuess=" + playerGuess + ", roundId=" + roundId + ", gameId=" + gameId + ", playerGuessCount=" + playerGuessCount + '}';
    }

}
