package com.example.adminpages;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText txtname,txtaddress,txtwebsite,txtlatitude,txtlongitude;
    DatabaseReference reff;
    long maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView btn1 = findViewById(R.id.restid);
        AdminModel adminModel = new AdminModel();
        reff = FirebaseDatabase.getInstance().getReference().child("adminModel");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        Log.e("TAG", "onCreate: "+database.getReference() );
        Log.e("TAG", "onCreate:" );


        myRef.setValue("Hello, World!");

        reff.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    maxid = (snapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateAddDialog();
            }
        });
    }

    private void CreateAddDialog() {
        AlertDialog.Builder alertLayout = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.activity_addhotels, null);
        alertLayout.setView(view);

        txtname = (EditText) view.findViewById(R.id.hotelid);
        txtaddress = (EditText) view.findViewById(R.id.addressid);
        txtwebsite = (EditText) view.findViewById(R.id.websiteid);
        txtlatitude = (EditText) view.findViewById(R.id.latitudeid);
        txtlongitude = (EditText) view.findViewById(R.id.longitudeid);
        Button btnSave = (Button) view.findViewById(R.id.btnid);
        AlertDialog alert = alertLayout.create();
        alert.show();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    AdminModel adminModel = new AdminModel();
                    adminModel.sethName(txtname.getText().toString());
                    adminModel.sethAddress(txtaddress.getText().toString());
                    adminModel.sethWebsite(txtaddress.getText().toString());
                    adminModel.setLat(Integer.parseInt(txtlatitude.getText().toString()));
                    adminModel.setLng(Integer.parseInt(txtlongitude.getText().toString()));
                    reff.child(String.valueOf(maxid+1)).setValue("adminModel");
                    Toast.makeText(MainActivity.this,"Data inserted successfully",Toast.LENGTH_LONG).show();
                    alert.dismiss();

                }catch (Exception ex){
                    Toast.makeText(MainActivity.this,"Input should bed"+ex, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}