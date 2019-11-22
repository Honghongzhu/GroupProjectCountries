package com.example.groupprojectcountries.asynctask;

import android.os.AsyncTask;

import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.User;

public class GetUserAsyncTask extends AsyncTask<Void, Integer, User> {

    private AsyncTaskDelegate delegate;
    private AppDatabase database;

    public void setDelegate(AsyncTaskDelegate delegate){
        this.delegate = delegate;
    }

    public void setDatabase(AppDatabase database){
        this.database = database;
    }


    @Override
    protected User doInBackground(Void... voids) {
        User user = database.userDao().getUser();
        return user;
    }

    @Override
    protected void onPostExecute(User result) {
        delegate.handleTaskResult(result);
    }
}
