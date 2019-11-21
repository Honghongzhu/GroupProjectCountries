package com.example.groupprojectcountries.flagGame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.cityGame.CityPracticeQuizActivity;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;
import com.example.groupprojectcountries.database.CountryDao;
import com.example.groupprojectcountries.flagGame.completed.FlagFinalResultsActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class FlagFinalQuizActivity extends AppCompatActivity {
    private EditText userInput;
    private Button checkAnswer;
    private ImageView flagImage;
    private Integer counter;
    private List<Country> countryList;
    private String CorrectAnswer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_final_quiz);

        AppDatabase db = AppDatabase.getInstance(this);
       // final String region = getIntent().getStringExtra("REGION");

        countryList = db.countryDao().getAll();

        userInput = findViewById(R.id.response_ffq);
        checkAnswer= findViewById(R.id.confirm3);
        flagImage = findViewById(R.id.fFlag_image);

        counter=0;
        CorrectAnswer=countryList.get(counter).getName().toUpperCase();
        //flagImage

        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userInput.getText().toString().toUpperCase().equals(CorrectAnswer)){
                    Toast.makeText(FlagFinalQuizActivity.this,
                            "Your answer was correct! You've earned 1 point", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(FlagFinalQuizActivity.this,
                            "Your answer was wrong. The correct answer was: " + countryList.get(counter).getName(), Toast.LENGTH_SHORT).show();
                }
                NextQuestion(counter,view);

            }
        });
    }

    public void NextQuestion(final int q,View view){
        Context context =  view.getContext();
        counter=q;
        counter++;
        if (counter<countryList.size()){

            CorrectAnswer=countryList.get(counter).getName();
            CorrectAnswer.toUpperCase();
            //flagImage.setImageResource(countryList.get(counter).getFlag());
        }else {
            Intent intent = new Intent(context, FlagFinalResultsActivity.class);
            context.startActivity(intent);
        }


    }
}
