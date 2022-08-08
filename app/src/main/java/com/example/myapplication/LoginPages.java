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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginPages extends AppCompatActivity {

    Button b1;
    EditText UnameD,PassD;
    TextView SignUp;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        UnameD = findViewById(R.id.dusername);
        PassD= findViewById(R.id.dpassword);
        b1 = findViewById(R.id.logbtn);
        mAuth = FirebaseAuth.getInstance();

        b1.setOnClickListener(view -> {
            loginUser();
        });
    }

    private void loginUser(){
        String email = UnameD.getText().toString();
        String pass = PassD.getText().toString();
        if(TextUtils.isEmpty(email)){
            UnameD.setError("Login should not be empty");
            UnameD.requestFocus();
        }else if(TextUtils.isEmpty(pass)){
            PassD.setError("Password should be entered");
            PassD.requestFocus();
        }else {
            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

                        String uid = task.getResult().getUser().getUid();

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        firebaseDatabase.getReference().child("Users").child(uid).child("usertype").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                int usertype = snapshot.getValue(Integer.class);
                                if(usertype == 0){
                                    Intent i = new Intent(LoginPages.this,HomePages.class);
                                    startActivity(i);

                                }
                                if (usertype == 1){
//                                    Intent i  =new Intent(LoginPages.this,AdminHome.class);
                                    Intent i = new Intent(LoginPages.this,RegisterPages.class);
                                    startActivity(i);

                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });



                        Toast.makeText(LoginPages.this,"User LogIn successful", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LoginPages.this,HomePages.class));
                    }else {
                        Toast.makeText(LoginPages.this,"LogIn Failed"+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
