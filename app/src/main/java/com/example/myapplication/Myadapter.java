package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.myviewholder> {

    ArrayList<RecyclerModule> datalist;
    public Myadapter(ArrayList<RecyclerModule> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.details_item,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.t1.setText(datalist.get(position).getName());
        holder.t2.setText(datalist.get(position).getAddress());
        holder.t3.setText(datalist.get(position).getWebsite());
        holder.t4.setText(datalist.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
    class myviewholder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3,t4,t5;

        public myviewholder(View view) {
            super(view);
            t1 = view.findViewById(R.id.t1);
            t2 = view.findViewById(R.id.t2);
            t3 = view.findViewById(R.id.t3);
            t4 = view.findViewById(R.id.t4);
        }
    }
}
