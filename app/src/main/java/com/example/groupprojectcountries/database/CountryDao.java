package com.example.groupprojectcountries.database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface CountryDao {
    @Query("SELECT * FROM country")
    List<Country> getAll();

    @Query("SELECT * FROM country WHERE region = :region")
    List<Country> findCountriesByRegion(String region);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Country> countries);



}
