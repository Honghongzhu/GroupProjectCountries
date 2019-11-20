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
import com.example.groupprojectcountries.play.PlayActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button playButton;
    public  List<APICountry> apiCountries;

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
//        String url = "https://restcountries.eu/#similar-projects";
//
//        Response.Listener<String> responseListener = new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                apiCountries = new Gson().fromJson(response,
//                        new TypeToken<List<APICountry>>() { }.getType());
//                for(int i = 0; i<apiCountries.size();i++){
//                    System.out.println(apiCountries.get(i).getName());
//
//                }
//            }
//        };
//
//        Response.ErrorListener errorListener = new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//                System.out.println("the request is failed!");
//            }
//        };
//        StringRequest stringRequest = new StringRequest(Request.Method.GET,url,responseListener,errorListener);
//
//        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//        requestQueue.add(stringRequest);


    }
}
