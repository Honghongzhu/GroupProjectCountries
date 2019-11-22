package com.example.groupprojectcountries.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Country.class, User.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CountryDao countryDao();
    public abstract UserDao userDao();

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "countryDb")
                    .build();
        }
        return instance;
    }
}
