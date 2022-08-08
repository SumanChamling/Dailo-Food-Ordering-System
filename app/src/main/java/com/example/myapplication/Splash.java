package com.example.myapplication;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        getSupportActionBar().hide();
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    sleep(10000);

                }catch(Exception ex){
                    ex.printStackTrace();

                }
                finally {

                    Intent i = new Intent(Splash.this,MainActivity.class);
                    startActivity(i);
                    finish();

                }

            }
        }); td.start();
    }
}