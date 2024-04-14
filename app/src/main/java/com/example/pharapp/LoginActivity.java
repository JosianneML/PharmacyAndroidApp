package com.example.pharapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btnLOGIN;
    TextView tvRegNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editTextLoginUserName);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btnLOGIN = findViewById(R.id.buttonLOGIN);
        tvRegNewUser = findViewById(R.id.textViewRegisterNewUser);

        btnLOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeeActivity.class));
                /*String usernameInput = edUsername.getText().toString();
                String passwordInput = edPassword.getText().toString();

                Database db = new Database(getApplicationContext(), "healthcare",null,1);

                if(usernameInput.length() ==0 || passwordInput.length() ==0){
                    Toast.makeText(getApplicationContext(), "Please Fill All Details!", Toast.LENGTH_SHORT).show();
                }else {
                    if(db.login(usernameInput, passwordInput)==1){
                        Toast.makeText(getApplicationContext(), "Login Success!", Toast.LENGTH_SHORT).show();
                        //SharedPreferences is like a small memory to store data
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        //to save our data with key and value
                        editor.putString("username", usernameInput);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this, HomeeActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Username and Password!", Toast.LENGTH_SHORT).show();
                    }
                }*/
            }
        });

        tvRegNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //explicit intent
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

    }
}