package com.example.viewsexample;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ListView listview = findViewById(R.id.listview);
        GridView listview = findViewById(R.id.listview);
        //normal listview example
//        String [] listitems ={"ram","shyam","Hari","Sita"};
//        ArrayAdapter adapter= new ArrayAdapter(MainActivity.this,R.layout.listitem,R.id.item,listitems);
//        listview.setAdapter(adapter);

        //custom Listview example
        List<Hobbies> Hobbies = new ArrayList<Hobbies>();
    Hobbies.add(new Hobbies(101,"Ram Sharma","dancing"));
        Hobbies.add(new Hobbies(102,"Sita Sharma","dancing"));
        Hobbies.add(new Hobbies(103,"Rita Sharma","Reading"));
        CustomListView adapter = new CustomListView(MainActivity.this,Hobbies);
        listview.setAdapter(adapter);


    }
}
