package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class RegisterPages extends AppCompatActivity {

    Button b1;
    TextView t1;
    EditText etName,etEmail,etPass,etCpass,etPhone,etAddress;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regester);

        etName = findViewById(R.id.Dname);
        etEmail = findViewById(R.id.Dusername);
        etPass = findViewById(R.id.Dpassword);
        etCpass = findViewById(R.id.Dconfirm);
        etPhone = findViewById(R.id.Dphone);
        etAddress = findViewById(R.id.Daddress);
        mAuth = FirebaseAuth.getInstance();

        b1 = findViewById(R.id.registerbtn);
        t1 = findViewById(R.id.signid);

        b1.setOnClickListener(view -> {
            createUser();
        });

        t1.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),LoginPages.class);
            startActivity(i);
        });
    }

    private void createUser(){
        String name  = etName.getText().toString();
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();
        String cpass = etCpass.getText().toString();
        String phone = etPhone.getText().toString();
        String address = etAddress.getText().toString();


//        Users userrrr = new Users(Name, Email, Password, Cpassword, PhoneNumber, Address);
//        userrrr.setName(name);
//        userrrr.setEmail(email);
//        userrrr.setPassword(pass);
//        userrrr.setCpassword(cpass);
//        userrrr.setPhoneNumber(phone);
//        userrrr.setAddress(address);

        if(TextUtils.isEmpty(name)){
            etName.setError("Name cannot be empty");
            etName.requestFocus();
        }
        else if (TextUtils.isEmpty(email)){
            etEmail.setError("Email cannot be empty");
            etEmail.requestFocus();
        }else if(TextUtils.isEmpty(pass)){
            etPass.setError("Password cannot be empty");
            etPass.requestFocus();
        }
        else if(TextUtils.isEmpty(cpass)){
            etCpass.setError("Confirm password should not be empty");
            etCpass.requestFocus();
        }
        else if(TextUtils.isEmpty(String.valueOf(phone))){
            etPhone.setError("Phone number should not be empty");
            etPhone.requestFocus();
        }
        else if(TextUtils.isEmpty(address)){
            etAddress.setError("Address should not be empty");
        }else{
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("Name",name);
            hashMap.put("Email",email);
            hashMap.put("Pass",pass);
            hashMap.put("Cpass",cpass);
            hashMap.put("Phone",phone);
            hashMap.put("Address",address);


            FirebaseFirestore.getInstance().collection("Users").document("UsersDat").set(hashMap)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(RegisterPages.this,"Registered successful", Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(RegisterPages.this,"Failed"+e.getMessage(), Toast.LENGTH_LONG).show();

                }
            });

        }
    }
//    private void addDataToFirestore(String Name, String Email, String Password, String Cpassword, String PhoneNumber, String Address){
//        //Creating the collection references for database
//        CollectionReference dbUser = db.collection("Users");
//
//        Users user = new Users(Name,Email,Password,Cpassword,PhoneNumber,Address);
//    }
}
