package com.example.groupprojectcountries.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    User getUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Query("SELECT * FROM user WHERE id LIKE :id")
    User findUserById(int id);

    @Query("UPDATE user SET score =:score")
    void updateScore(int score);

    @Query("UPDATE user SET scorePerRound =:scorePerRound")
    void updateScorePerRound(int scorePerRound);
}
