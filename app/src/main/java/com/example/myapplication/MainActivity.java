package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.startbtn);
//        FirebaseAuth mAuth = FirebaseAuth.getInstance();
//        Users user = new Users(Name, Email, Password, Cpassword, PhoneNumber, Address);
//        user.setAddress("ktm");
//        user.setName("Ram");
//        user.setCpassword("somerjer");
//        user.setPhoneNumber("94");
////        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
////        Log.e("TAG", "onCreate: "+firebaseDatabase);
//
//
//
//
//
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("Users");
//
//        myRef.setValue(user);
//
////        Log.e("TAG", "onCreate: "+firebaseDatabase.getReference().child("Users") );
//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference ref = database.getReference("Users");
//        DatabaseReference usersRef = ref.child("users");


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, WelcomePages.class);
                startActivity(i);
            }
        });


    }
}