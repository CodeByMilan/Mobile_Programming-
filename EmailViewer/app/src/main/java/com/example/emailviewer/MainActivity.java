package com.example.emailviewer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RecyclerView recyclerview = findViewById(R.id.recycler_view);
//        LinearLayoutManager layout = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
//        recyclerview.setLayoutManager(layout);

        List<EmailItems> data = new ArrayList<>();
        data.add(new EmailItems("M","Milan","hello milan here "));
        data.add(new EmailItems("M","Milan","hello milan here "));
        data.add(new EmailItems("M","Milan","hello milan here "));
        data.add(new EmailItems("M","Milan","hello milan here "));
        data.add(new EmailItems("M","Milan","hello milan here "));
        data.add(new EmailItems("M","Milan","hello milan here "));

//        MailAdapter adapter=new MailAdapter(data);
//        recyclerview.setAdapter(adapter);

//        ListView listView=findViewById(R.id.listview);
//        MailArrayAdapter adapter=new MailArrayAdapter(MainActivity.this,data);
//        listView.setAdapter(adapter);

        GridView gridView = findViewById(R.id.gridview);
        MailArrayAdapter adapter=new MailArrayAdapter(MainActivity.this,data);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                EmailItems clickedItem = data.get(position);


                Intent intent = new Intent(MainActivity.this, EmailDetailActivity.class);
                intent.putExtra("initial", clickedItem.getTitleInitial());
                intent.putExtra("Title", clickedItem.getTitle());
                intent.putExtra("Description", clickedItem.getDescription());


                startActivity(intent);
            }
        });




    }
}
