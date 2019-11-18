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

}
