package com.example.groupprojectcountries.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Country.class, User.class,Badges.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CountryDao countryDao();
    public abstract UserDao userDao();
    public abstract BadgesDao badgesDao();

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "countryDb")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
