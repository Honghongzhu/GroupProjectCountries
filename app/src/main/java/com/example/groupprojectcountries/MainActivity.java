package com.example.groupprojectcountries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.User;
import com.example.groupprojectcountries.play.PlayActivity;

public class MainActivity extends AppCompatActivity {

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
        db.userDao().insertUser(new User(1, "Username"));
    }
}
