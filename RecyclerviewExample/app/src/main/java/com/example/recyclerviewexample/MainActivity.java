package com.example.recyclerviewexample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Hobbies> Hobbies = new ArrayList<Hobbies>();
        Hobbies.add(new Hobbies(101,"Ram Sharma","dancing"));
        Hobbies.add(new Hobbies(102,"Sita Sharma","dancing"));
        Hobbies.add(new Hobbies(103,"Rita Sharma","Reading"));
        Hobbies.add(new Hobbies(103,"Rita Sharma","Reading"));
        Hobbies.add(new Hobbies(103,"Rita Sharma","Reading"));
        Hobbies.add(new Hobbies(103,"Rita Sharma","Reading"));
        Hobbies.add(new Hobbies(103,"Rita Sharma","Reading"));
        Hobbies.add(new Hobbies(103,"Rita Sharma","Reading"));

RecyclerView recyclerView=findViewById(R.id.recylerview);
GridLayoutManager layoutManager= new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
recyclerView.setLayoutManager(layoutManager);

RecyclerViewAdapter adapter = new RecyclerViewAdapter(Hobbies);
recyclerView.setAdapter(adapter);

    }
}
