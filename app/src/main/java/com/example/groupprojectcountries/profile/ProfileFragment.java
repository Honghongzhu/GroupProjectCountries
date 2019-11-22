package com.example.groupprojectcountries.profile;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.database.AppDatabase;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment{

    private ImageView userPhoto;
    private TextView userName;
    private TextView userScore;

    private LinearLayout africa;
    private LinearLayout americas;
    private LinearLayout asia;
    private LinearLayout europe;
    private LinearLayout oceania;
    private static boolean africaBollean;
    private static boolean americasBollean;
    private static boolean aisaBollean;
    private static boolean europeBollean;
    private static boolean oceaniaBollean;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        Context context = v.getContext();
        AppDatabase db = AppDatabase.getInstance(context);

        //TODO: create a database or fake data base to get the user information
        userPhoto = v.findViewById(R.id.profile_photo);
        //user_photo.setImageResource();//set user profile

        userName = v.findViewById(R.id.profile_name);
        String name = db.userDao().getUser().getName();
        userName.setText(name);

        userScore = v.findViewById(R.id.profile_score);
        int score = db.userDao().getUser().getScore();
        userScore.setText(String.format(Locale.getDefault(),"Score %s", score));

        africa = v.findViewById(R.id.africa_badge);
        americas=v.findViewById(R.id.americas_badge);
        asia=v.findViewById(R.id.asia_badge);
        europe=v.findViewById(R.id.europe_badge);
        oceania=v.findViewById(R.id.oceania_badge);

        if (africaBollean){
            africa.setForeground(Drawable.createFromPath("#00FFFFFF"));
        }

        if(americasBollean){
            americas.setForeground(Drawable.createFromPath("#00FFFFFF"));
        }

        if(aisaBollean){
            asia.setForeground(Drawable.createFromPath("#00FFFFFF"));
        }

        if(europeBollean){
            europe.setForeground(Drawable.createFromPath("#00FFFFFF"));
        }

        if(oceaniaBollean){
            oceania.setForeground(Drawable.createFromPath("#00FFFFFF"));
        }
        return v;

    }

    public static void UnlockBadges(String region){
        if(region.toLowerCase().equals("africa")){
            africaBollean=true;
        }else if(region.toLowerCase().equals("americas")){
            americasBollean=true;
        }else if(region.toLowerCase().equals("asia")){
            aisaBollean=true;
        }else if(region.toLowerCase().equals("europe")){
            europeBollean=true;
        }else {//oceania
            oceaniaBollean=true;

        }

    }
}