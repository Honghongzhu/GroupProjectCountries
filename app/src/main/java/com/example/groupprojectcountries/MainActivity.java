package com.example.groupprojectcountries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.groupprojectcountries.asynctask.AsyncTaskDelegate;
import com.example.groupprojectcountries.asynctask.InsertUserAsyncTask;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;
import com.example.groupprojectcountries.database.User;
import com.example.groupprojectcountries.play.PlayActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AsyncTaskDelegate {

    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //When clicked on the 'play' button, the user will be directed to the PlayActivity screen.
        playButton = findViewById(R.id.play);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, PlayActivity.class);
                context.startActivity(intent);
            }
        });

        AppDatabase db = AppDatabase.getInstance(this);
        InsertUserAsyncTask insertUserAsyncTask = new InsertUserAsyncTask();
        insertUserAsyncTask.setDatabase(db);
        insertUserAsyncTask.setDelegate(this);
        insertUserAsyncTask.execute(new User(1, "Username"));
    }

    @Override
    public void handleTaskResult(List<Country> result) {

    }

    @Override
    public void handleTaskResult(String result) {

    }

    @Override
    public void handleTaskResult(User result) {

    }
}
