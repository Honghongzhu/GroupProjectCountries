package com.example.groupprojectcountries.cityGame.completed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.asynctask.AsyncTaskDelegate;
import com.example.groupprojectcountries.asynctask.GetUserAsyncTask;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;
import com.example.groupprojectcountries.database.User;
import com.example.groupprojectcountries.play.PlayActivity;

import java.util.List;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CityFinalResultsActivity extends AppCompatActivity implements AsyncTaskDelegate {

    private Button okButton;
    private TextView score;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_results);
        score = findViewById(R.id.nPoints);

        AppDatabase db = AppDatabase.getInstance(this);
        GetUserAsyncTask getUserAsyncTask = new GetUserAsyncTask();
        getUserAsyncTask.setDatabase(db);
        getUserAsyncTask.setDelegate(this);
        getUserAsyncTask.execute();

        okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, PlayActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void handleTaskResult(List<Country> result) {

    }

    @Override
    public void handleTaskResult(String result) {

    }

    @Override
    public void handleTaskResult(User result) {
        int scoreDb = result.getScorePerRound();
        score.setText(String.format(Locale.getDefault(), "%s", scoreDb));
    }
}
