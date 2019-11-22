package com.example.groupprojectcountries.asynctask;

import android.os.AsyncTask;

import com.example.groupprojectcountries.database.AppDatabase;

public class UpdateScoreAsyncTask extends AsyncTask<Integer, Integer, String> {

    private AsyncTaskDelegate delegate;
    private AppDatabase database;

    public void setDelegate(AsyncTaskDelegate delegate){
        this.delegate = delegate;
    }

    public void setDatabase(AppDatabase database){
        this.database = database;
    }

    @Override
    protected String doInBackground(Integer... integers) {
        database.userDao().updateScore(integers[0]);
        return "This value will be passed to onPostExecute as the result parameter";
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.handleTaskResult(result);
    }
}
