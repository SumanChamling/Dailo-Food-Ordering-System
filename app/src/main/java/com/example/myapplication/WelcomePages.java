package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class WelcomePages extends AppCompatActivity {
    Button b1,b2;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        checkLoginStatus();

        b1= findViewById(R.id.loginbtn);
        b2 = findViewById(R.id.registerbtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomePages.this,LoginPages
                        .class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomePages.this,RegisterPages
                        .class);
                startActivity(i);
            }
        });
    }
    private void checkLoginStatus() {

        SharedPreferences sp = getSharedPreferences("state",MODE_PRIVATE);
        boolean state = sp.getBoolean("loginstate", false);

        if(state){
            Intent i = new Intent(WelcomePages.this,HomePages.class);
            startActivity(i);

        }
    }
}
