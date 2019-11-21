package com.example.groupprojectcountries.flagGame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.cityGame.completed.CityReadyToPracticeActivity;
import com.example.groupprojectcountries.database.AppDatabase;
import com.example.groupprojectcountries.database.Country;
import com.example.groupprojectcountries.flagGame.completed.FlagReadyToPracticeActivity;

import java.util.List;

public class FlagFlashcardsActivity extends AppCompatActivity{

    private TextView countryName;
    private ImageView flag;
    private Button next;
    private int counter;
    private String region;
    private String category;
    private String level;
    private String flagUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_flashcard);
        countryName = findViewById(R.id.fCountry_name_flash);
        flag = findViewById(R.id.country_flag_flash);
        next = findViewById(R.id.next_flag);

        AppDatabase db = AppDatabase.getInstance(this);
        region = getIntent().getStringExtra("REGION");
        category = getIntent().getStringExtra("CATEGORY"); //not necessary
        level = getIntent().getStringExtra("LEVEL");

        List<Country> countryList = db.countryDao().getCountriesByRegion(region);

        int amount = countryList.size() / 4;

        final List<Country> subListOne = countryList.subList(0, amount);
        final List<Country> subListTwo = countryList.subList(amount, amount *2);
        final List<Country> subListThree = countryList.subList(amount *2, amount *3);
        final List<Country> subListFour = countryList.subList(amount *3, countryList.size());
        counter = 0;

        switch (level){
            case "1":
                countryName.setText(subListOne.get(0).getName());
                flagUrl = subListOne.get(0).getFlag();
                Glide.with(this).load(flagUrl).into(flag);
                changeCard(subListOne, "1");
                break;
            case "2":
                countryName.setText(subListTwo.get(0).getName());
                flagUrl = subListTwo.get(0).getFlag();
                Glide.with(this).load(flagUrl).into(flag);
                changeCard(subListTwo, "2");
                break;
            case "3":
                countryName.setText(subListThree.get(0).getName());
                flagUrl = subListThree.get(0).getFlag();
                Glide.with(this).load(flagUrl).into(flag);
                changeCard(subListThree, "3");
                break;
            case "4":
                countryName.setText(subListFour.get(0).getName());
                flagUrl = subListFour.get(0).getFlag();
                Glide.with(this).load(flagUrl).into(flag);
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
                if(counter!=subList.size()-1) {
                    countryName.setText(subList.get(counter+1).getName());
                    String flagUrl = subList.get(counter+1).getFlag();
                    Glide.with(context).load(flagUrl).into(flag);
                    counter++;
                }
                else{
                    Intent intent = new Intent(context, FlagReadyToPracticeActivity.class);
                    intent.putExtra("REGION", region);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("LEVEL", level);
                    context.startActivity(intent);
                }
            }
        });
    }
}
