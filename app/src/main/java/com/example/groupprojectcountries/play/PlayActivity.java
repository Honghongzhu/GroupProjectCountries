package com.example.groupprojectcountries.play;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.groupprojectcountries.R;
import com.example.groupprojectcountries.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PlayActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Fragment fragment = new RegionRecyclerFragment();
        swapFragment(fragment);

        //If the user clicks on the learning button, the user will be navigated to the learning fragment.
        //If the user clicks on the profile button, the user will be navigated to the profile fragment.
        bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.navigation_learn){
                    Fragment fragment = new RegionRecyclerFragment();
                    swapFragment(fragment);
                    return true;
                }else if (menuItem.getItemId() == R.id.navigation_profile){
                    Fragment fragment = new ProfileFragment();
                    swapFragment(fragment);
                    return true;
                }
                return false;
            }
        });
    }

    //This function is used to change fragments
    private void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_slot, fragment);
        fragmentTransaction.commit();
    }

}
