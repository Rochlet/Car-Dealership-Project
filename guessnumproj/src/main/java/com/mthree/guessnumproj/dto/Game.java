/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.guessnumproj.dto;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ArmandoGonzalez
 */
public class Game {

    private int id;
    private String answer;
    private List<Round> rounds;
    private boolean inProgress;
    private String player;


    //id required to create game object
    public Game(int id) {
 
        this.id = id;
        this.rounds = new ArrayList<>();
    }

    public Game() {
         this.id = 1;
    }

    //only getter for id
    public int getId() {
        return id;
    }

    //getters and setters
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Game{" + "id=" + id + ", answer=" + answer + ", rounds=" + rounds + ", inProgress=" + inProgress + ", player=" + player + '}';
    }

    
}
