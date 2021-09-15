/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.guessnumproj.service;

import com.mthree.guessnumproj.dto.*;
import com.mthree.guessnumproj.dao.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
/**
 *
 * @author ArmandoGonzalez
 */
public class ServiceImpl implements Service{
    private Random rnd = new Random();
    
    GameDao gameDao;
    RoundDao roundDao;

    @Autowired
    public ServiceImpl(GameDao dao, RoundDao roundDao) {
        this.gameDao = gameDao;
        this.roundDao = roundDao;
    }
    
    
    @Override
    public Game startgame() {
        int gameId = this.rnd.nextInt() % (100000 - 0 + 1);
        Game game = new Game(gameId);
        //set answer before returning game object
        game.setAnswer(this.generateNumStr());
        return game;
    }

    @Override
    public Round guess(Round r){
        int gameID = r.getGameId();
        String guess = getGame(gameID).getAnswer();
        return guess(gameID, guess);
    }
    
    @Override
    public Round guess(int gameID, String guess)  throws DataAccessException {
        try {
            Round round = new Round(LocalDateTime.now());
            Game game = this.gameDao.getGameById(gameID);
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
        catch(Exception dae){     
            throw new DataAccessException("Could not retrieve game object.") {};
        }
        
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
    public Game getGame(int gameId) throws DataAccessException{
        try {
            return this.gameDao.getGameById(gameId);
        }
        catch(Exception dae){     
            throw new DataAccessException("Could not retrieve game object.") {};
        }
    }
    
    @Override
    public List<Game> getAllGames() throws DataAccessException {
        try {
            return this.gameDao.getAllGames();
        }
        catch(Exception dae){     
            throw new DataAccessException("Could not retrieve game object.") {};
        }
    }

    @Override
    public List<Round> getRounds(int gameId) throws DataAccessException {
        try {
            return this.roundDao.getAllRoundsByGameId(gameId);
        }
        catch(Exception dae){    
            throw new DataAccessException("Could not retrieve game object.") {};
        }
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
