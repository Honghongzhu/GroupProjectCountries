package com.example.groupprojectcountries.asynctask;

import com.example.groupprojectcountries.database.Country;
import com.example.groupprojectcountries.database.User;

import java.util.List;

public interface AsyncTaskDelegate {
    void handleTaskResult(List<Country> result);
    void handleTaskResult(String result);
    void handleTaskResult(User result);
}
