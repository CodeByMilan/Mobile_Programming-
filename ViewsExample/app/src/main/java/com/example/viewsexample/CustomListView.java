package com.example.viewsexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class CustomListView extends ArrayAdapter {
    private List<Hobbies> hobbies ;
    public CustomListView(Context context , List<Hobbies> hobbies){
        super(context,0,hobbies);
       this.hobbies=hobbies;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.listitem,parent,false);
        }
        Hobbies h = hobbies.get(position);

        TextView idview =convertView.findViewById(R.id.id);
        TextView nameview = convertView.findViewById(R.id.name);
        TextView hobbiesview =convertView.findViewById(R.id.hobbies);

        idview.setText(String.valueOf(h.getId()));
        nameview.setText(h.getName());
        hobbiesview.setText(h.getHobbies());

        return convertView;


    }
}
