package com.example.groupprojectcountries.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    private int id;
    private int score;
    private int scorePerRound;
    private String name;

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setScorePerRound(int scorePerRound) {
        this.scorePerRound = scorePerRound;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getScorePerRound() {
        return scorePerRound;
    }
}
