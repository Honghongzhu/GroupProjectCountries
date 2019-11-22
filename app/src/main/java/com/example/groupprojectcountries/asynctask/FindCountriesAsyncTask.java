package com.example.groupprojectcountries.asynctask;

import android.os.AsyncTask;

import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;

import java.util.List;

public class FindCountriesAsyncTask extends AsyncTask<String, Integer, List<Country>> {

    private AsyncTaskDelegate delegate;
    private AppDatabase database;

    public void setDelegate(AsyncTaskDelegate delegate){
        this.delegate = delegate;
    }

    public void setDatabase(AppDatabase database){
        this.database = database;
    }

    @Override
    protected List<Country> doInBackground(String... strings) {
        List<Country> country = database.countryDao().findCountriesByRegion(strings[0]);
        return country;
    }

    @Override
    protected void onPostExecute(List<Country> result) {
        delegate.handleTaskResult(result);
    }
}
