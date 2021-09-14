/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.guessnumproj.service;

import com.mthree.guessnumproj.dto.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ArmandoGonzalez
 */
public class ServiceImpl implements Service{
    private Random rnd = new Random();
    
    /*Dao dao;

    public ServiceImpl(Dao dao) {
        this.dao = dao;
    }
    */
    
    @Override
    public Game startgame() {
        int gameId = this.rnd.nextInt() % (100000 - 0 + 1);
        Game game = new Game(gameId);
        //set answer before returning game object
        game.setAnswer(this.generateNumStr());
        return game;
    }

    //create round and set round attributes
    @Override
    public Round guess(Game game, String guess) {
        Round round = new Round(LocalDateTime.now());
        List<Round> rounds = game.getRounds();
        if( !this.isPlayerWin(game)) {
            rounds.add(round);
            round.setPlayerGuess(guess);
            round.setExactMatchCount(this.calcExactMatch(guess, game));
            round.setPartialMatch(this.calcPartialMatch(guess, game));
            //should return round here
        }
        //exception should be thrown here
        return round;
    }

    @Override
    public int getExactMatchVal(String guess, Game game) {
        List<Round> rounds = game.getRounds();
        Round lastRound = rounds.get(rounds.size()-1);
        return lastRound.getExactMatchCount();
    }

    @Override
    public int getPartialMatchVal(String guess, Game game) {
        List<Round> rounds = game.getRounds();
        Round lastRound = rounds.get(rounds.size()-1);
        return lastRound.getPartialMatch();
    }

    @Override
    public boolean isNumStrValid(String numStr) {
        char[] nums = numStr.toCharArray();
        //check if string is 4 character long
        if(numStr.length() != 4) return false;
        for(char num : nums) {
            //check if a digit
            if(!Character.isDigit(num)) return false;
            //check if unique
            if(numStr.indexOf(num) != numStr.lastIndexOf(num)) return false;
        }
        return true;
    }
    
    //modifies string to be 3 chars long
    @Override
    public String addPlayerInitials(String playerInitials, Game game) {
        while(playerInitials.length() < 3)
            playerInitials += "_";
        playerInitials = playerInitials.substring(0,3);
        game.setPlayer(playerInitials);
        return game.getPlayer();
    }

    @Override
    public boolean isPlayerWin(Game game) {
        List<Round> rounds = game.getRounds();
        if(rounds.size() == 0) return false;
        Round lastRound = rounds.get(rounds.size()-1);
        int exactMatch = lastRound.getExactMatchCount();
        return exactMatch == 4;
    }

    @Override
    public Game getGame(int gameId) {
        //this.dao.getgame(gameId);
        return new Game(0);
    }

    @Override
    public List<Round> getRounds(int gameId) {
       //this.dao.getRounds(gameId);
       return new ArrayList<Round>();
    }
    
    
    //utility methods
    private int calcExactMatch(String guess, Game game) {
        int count = 0;
        String answer = game.getAnswer();
        //break guess into chars
        char[] nums = guess.toCharArray();
        //check if the position in guess is exactly the same in answer for each char
        for(char num : nums)
            if(guess.indexOf(num) == answer.lastIndexOf(num))
                count++;
        return count;
    }
    
    private int calcPartialMatch(String guess, Game game) {
        int count = 0;
        String answer = game.getAnswer();
        //break guess into chars
        char[] nums = guess.toCharArray();
        //check if the position of each char is anywhere in answer
        for(char num : nums)
            if(answer.indexOf(num) != -1)
                count++;
        return count;
    }
    
    //generate an answer for game object
    private String generateNumStr() {
        String nums = "0123456789";
        int strIdx;
        String numStr = "";
        char currChar;
        while(numStr.length() < 4) {
            strIdx = this.rnd.nextInt(9);
            currChar = nums.charAt(strIdx);
            if(!numStr.contains(currChar+""))
                numStr += currChar;
        }
        return numStr;
    }
}
