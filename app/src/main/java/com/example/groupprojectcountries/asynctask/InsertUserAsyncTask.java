package com.example.groupprojectcountries.asynctask;

import android.os.AsyncTask;

import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.User;

import java.util.Arrays;

public class InsertUserAsyncTask extends AsyncTask<User, Integer, String> {

    private AsyncTaskDelegate delegate;
    private AppDatabase database;

    public void setDelegate(AsyncTaskDelegate delegate){
        this.delegate = delegate;
    }

    public void setDatabase(AppDatabase database){
        this.database = database;
    }

    @Override
    protected String doInBackground(User... users) {
        database.userDao().insertUser(users[0]);
        return "This value will be passed to onPostExecute as the result parameter";
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.handleTaskResult(result);
    }
}
