package com.example.recyclerviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<HobbiesViewHolder> {
    private List<Hobbies>hobbies;
    public RecyclerViewAdapter(List<Hobbies>hobies) {
        this.hobbies=hobies;
    }

    @NonNull
    @Override
    public HobbiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item,parent,false);
        return new HobbiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HobbiesViewHolder holder, int position) {
        Hobbies currentItem = hobbies.get(position);


        holder.idview.setText(String.valueOf(currentItem.getId()));
        holder.nameview.setText(currentItem.getName());
        holder.hobbiesview.setText(currentItem.getHobbies());
    }

    @Override
    public int getItemCount() {
        return hobbies.size();
    }
}
class HobbiesViewHolder extends RecyclerView.ViewHolder{
    public TextView idview , nameview , hobbiesview;
    public HobbiesViewHolder(@NonNull View itemView) {
        super(itemView);
        idview=itemView.findViewById(R.id.id);
        nameview=itemView.findViewById(R.id.name);
        hobbiesview=itemView.findViewById(R.id.hobbies);
    }
}