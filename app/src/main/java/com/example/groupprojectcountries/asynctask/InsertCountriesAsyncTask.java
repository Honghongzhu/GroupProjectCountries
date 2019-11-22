package com.example.groupprojectcountries.asynctask;

import android.os.AsyncTask;

import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;

import java.util.Arrays;

public class InsertCountriesAsyncTask extends AsyncTask<Country, Integer, String> {
    private AsyncTaskDelegate delegate;
    private AppDatabase database;

    public void setDelegate(AsyncTaskDelegate delegate) {
        this.delegate = delegate;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    @Override
    protected String doInBackground(Country... countries) {
        database.countryDao().insertAll(Arrays.asList(countries));
        return "This value will be passed to onPostExecute as the result parameter";
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.handleTaskResult(result);
    }
}
