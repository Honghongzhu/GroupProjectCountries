package com.example.groupprojectcountries.cityGame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.cityGame.completed.CityPracticeCompletedActivity;
import com.example.groupprojectcountries.cityGame.completed.CityReadyToPracticeActivity;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CityPracticeQuizActivity extends AppCompatActivity {

    private TextView questionNr;
    private TextView countryName;
    private EditText response;
    private Button confirm;
    private String region;
    private String category;
    private String level;
    private int counter;
    private int nr;
    private String answer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_practice_quiz);

        questionNr = findViewById(R.id.pQuiz_count_city);
        countryName = findViewById(R.id.pCity_text);
        response = findViewById(R.id.response_pcq);
        confirm = findViewById(R.id.confirm2);
        region = getIntent().getStringExtra("REGION");
        category = getIntent().getStringExtra("CATEGORY"); //not necessary
        level = getIntent().getStringExtra("LEVEL");

        AppDatabase db = AppDatabase.getInstance(this);
        List<Country> countryList = db.countryDao().getCountriesByRegion(region);

        int amount = countryList.size() / 4;

        final List<Country> subListOne = countryList.subList(0, amount);
        final List<Country> subListTwo = countryList.subList(amount, amount *2);
        final List<Country> subListThree = countryList.subList(amount *2, amount *3);
        final List<Country> subListFour = countryList.subList(amount *3, countryList.size());

        switch (level){
            case "1":
                questionNr.setText(String.format(Locale.getDefault(),"Question %s", 1));
                countryName.setText(subListOne.get(0).getName());
                counter = 0;
                changeCountry(subListOne, "1");
                break;
            case "2":
                questionNr.setText(String.format(Locale.getDefault(),"Question %s", 1));
                countryName.setText(subListTwo.get(0).getName());
                counter = 0;
                changeCountry(subListTwo, "2");
                break;
            case "3":
                questionNr.setText(String.format(Locale.getDefault(),"Question %s", 1));
                countryName.setText(subListThree.get(0).getName());
                counter = 0;
                changeCountry(subListThree, "3");
                break;
            case "4":
                questionNr.setText(String.format(Locale.getDefault(),"Question %s", 1));
                countryName.setText(subListFour.get(0).getName());
                counter = 0;
                changeCountry(subListFour, "4");
                break;
            case "5":
                questionNr.setText(String.format(Locale.getDefault(),"Question %s", 1));
                countryName.setText(countryList.get(0).getName());
            default:
                System.out.println("nothing");
        }
    }

    public void changeCountry(final List<Country> subList, final String level){
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context =  v.getContext();
                if(counter!=subList.size()-1){
                    answer = response.getText().toString();
                    if(answer.equals(subList.get(counter).getCapital()))
                        Toast.makeText(CityPracticeQuizActivity.this,
                                "Your answer was correct! You've earned 1 point", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(CityPracticeQuizActivity.this,
                                "Your answer was wrong. The correct answer was: " + subList.get(counter).getCapital(), Toast.LENGTH_SHORT).show();
                    nr++;
                    questionNr.setText(String.format(Locale.getDefault(),"Question %s", nr));
                    countryName.setText(subList.get(counter+1).getName());
                    counter++;
                }
                else{
                    Intent intent = new Intent(context, CityPracticeCompletedActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", level);
                    context.startActivity(intent);
                }
            }
        });
    }

}
