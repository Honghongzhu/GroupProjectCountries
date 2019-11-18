package com.example.groupprojectcountries.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Country {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Capital")
    private String capital;

    @ColumnInfo(name = "Region")
    private String region;

    @ColumnInfo(name = "Flag")
    private String flag;

    @ColumnInfo(name = "Score")
    private int score;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getFlag() {
        return flag;
    }

    public int getScore() {
        return score;
    }
}
