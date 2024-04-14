package com.example.pharapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homee);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();
        Toast.makeText(getApplicationContext(), "Welcome "+username+ " !", Toast.LENGTH_SHORT).show();

        CardView cvExit = findViewById(R.id.cardExit);
        cvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear the user from the local memory
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                startActivity(new Intent(HomeeActivity.this, LoginActivity.class));
            }
        });

        CardView cvFindDoctor = findViewById(R.id.cardFindDoctor);
        cvFindDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeeActivity.this, FindDoctorActivity.class));
            }
        });

        CardView cvLabTest = findViewById(R.id.cardLabTest);
        cvLabTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeeActivity.this, LabTestActivity.class));
            }
        });

    }
}