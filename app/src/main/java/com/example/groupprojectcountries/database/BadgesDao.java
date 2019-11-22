package com.example.groupprojectcountries.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BadgesDao {
    @Query("SELECT * FROM Badges")
    List<Badges> getAll();

    @Query("SELECT * FROM Badges WHERE region = :region")
    List<Badges> getBadgesByRegion(String region);

}
