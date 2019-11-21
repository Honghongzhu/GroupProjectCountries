package com.example.groupprojectcountries.cityGame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.cityGame.completed.CityReadyToPracticeActivity;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;
import com.example.groupprojectcountries.play.LevelActivity;

import java.util.List;

public class CityFlashcardsActivity extends AppCompatActivity {

    private TextView countryName;
    private TextView capitalCity;
    private ImageButton next;
    private int counter;
    private int amount;
    private String region;
    private String category;
    private String level;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_flashcard);

        countryName = findViewById(R.id.country_name_flash);
        capitalCity = findViewById(R.id.country_city_flash);
        next = findViewById(R.id.next_city);

        AppDatabase db = AppDatabase.getInstance(this);
        region = getIntent().getStringExtra("REGION");
        category = getIntent().getStringExtra("CATEGORY"); //not necessary
        level = getIntent().getStringExtra("LEVEL");
        System.out.println("Region:" + region + " Category:" + category + " Level:" + level);

        List<Country> countryList = db.countryDao().getCountriesByRegion(region);

        amount = countryList.size()/4;

        final List<Country> subListOne = countryList.subList(0, amount);
        final List<Country> subListTwo = countryList.subList(amount, amount*2);
        final List<Country> subListThree = countryList.subList(amount*2, amount*3);
        final List<Country> subListFour = countryList.subList(amount*3, countryList.size());

        switch (level){
            case "1":
                countryName.setText(subListOne.get(0).getName());
                capitalCity.setText(subListOne.get(0).getCapital());
                counter = 0;
                changeCard(subListOne, "1");
                break;
            case "2":
                countryName.setText(subListTwo.get(0).getName());
                capitalCity.setText(subListTwo.get(0).getCapital());
                counter = 0;
                changeCard(subListTwo, "2");
                break;
            case "3":
                countryName.setText(subListThree.get(0).getName());
                capitalCity.setText(subListThree.get(0).getCapital());
                counter = 0;
                changeCard(subListThree, "3");
                break;
            case "4":
                countryName.setText(subListFour.get(0).getName());
                capitalCity.setText(subListFour.get(0).getCapital());
                counter = 0;
                changeCard(subListFour, "4");
                break;
            default:
                System.out.println("nothing");
        }

    }

    public void changeCard(final List<Country> subList, final String level){
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context =  v.getContext();
                if(counter!=subList.size()) {
                    countryName.setText(subList.get(counter).getName());
                    capitalCity.setText(subList.get(counter).getCapital());
                    counter++;
                }
                else{
                    Intent intent = new Intent(context, CityReadyToPracticeActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", level);
                    context.startActivity(intent);
                }
            }
        });
    }




}
