package com.example.pharapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername, edEmail, edPassword, edPassConfirm;
    Button btnRegister;
    TextView tvAlreadyUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextRegisterUserName);
        edEmail = findViewById(R.id.editTextRegisterUserEmail);
        edPassword = findViewById(R.id.editTextRegisterPassword);
        edPassConfirm = findViewById(R.id.editTextRegisterConfirmPassword);
        btnRegister = findViewById(R.id.buttonREGISTER);
        tvAlreadyUser = findViewById(R.id.textViewExistingUser);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameInput = edUsername.getText().toString();
                String emailInput = edEmail.getText().toString();
                String passwordInput = edPassword.getText().toString();
                String passwordconfInput = edPassConfirm.getText().toString();

                Database db = new Database(getApplicationContext(), "healthcare",null,1);

                if(usernameInput.length() ==0 || emailInput.length() ==0 || passwordInput.length() ==0 || passwordconfInput.length() ==0 ){
                    Toast.makeText(getApplicationContext(), "Please Fill All Details!", Toast.LENGTH_SHORT).show();
                }else {
                    if(passwordInput.compareTo(passwordconfInput)==0){
                        if(isValid(passwordInput)){
                            db.register(usernameInput, emailInput, passwordInput);

                            Toast.makeText(getApplicationContext(), "Registration Success!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters; Letters, Digits, and Special Character.", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(getApplicationContext(), "Password and Confirm Password didn't match!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tvAlreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //explicit intent
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    public static boolean isValid(String passwordhere) {
        int f1=0, f2=0, f3=0;
        if(passwordhere.length() < 8) {
            return false;
        } else {
            for(int p =0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for(int r =0; r <passwordhere.length(); r++){
                if (Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            for(int s =0; s <passwordhere.length(); s++){
                char c = passwordhere.charAt(s);
                if (c>=33 && c<=46 || c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }
    }


}