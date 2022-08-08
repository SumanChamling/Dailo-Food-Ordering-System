//package com.example.myapplication;
//
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.QuerySnapshot;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BodyResturand extends AppCompatActivity {
//    private RecyclerView rv;
//    ArrayList<RecyclerModule> datalist;
//    FirebaseFirestore db;
//    Myadapter adapter;
//
//    @Override
//    protected void onCreate( Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_resturand);
//        rv = findViewById(R.id.recycleid);
//        rv.setLayoutManager(new LinearLayoutManager(this));
//        datalist = new ArrayList<>();
//        adapter = new Myadapter(datalist);
//        rv.setAdapter(adapter);
//
//        db = FirebaseFirestore.getInstance();
//
//        //collects all the data and stored into the list
//        db.collection("HotelDetails").orderBy("name").get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
//                        for (DocumentSnapshot d:list){
//                            RecyclerModule obj = d.toObject(RecyclerModule.class);
//                            datalist.add(obj);
//                        }
//                        adapter.notifyDataSetChanged();
//                    }
//                });
//
//
//    }
//}
//
