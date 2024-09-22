package com.example.lab2;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private Button insert ,show_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
     ListView listview=findViewById(R.id.listview);
     insert=findViewById(R.id.insert);
     show_data=findViewById(R.id.show);

        DBhelper helper = new DBhelper(this);
      insert.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            helper.InsertData("110","Ram Sharma","he is a bca student");
              helper.InsertData("111","Ram Gurung","he is a btec student");
              helper.InsertData("112","Ram Lama","he is a bm student");
              helper.InsertData("113","Ram Khatri","he is a bba student");
              helper.InsertData("114","Ram Adhikari","he is a ba student");
              Toast.makeText(MainActivity.this,"Data Inserted Succssfylly",Toast.LENGTH_SHORT).show();
          }
      });
      show_data.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String uid = "";
              String title = "";
              String description = "";

              ArrayList<Note> noteList = new ArrayList<>();

              Cursor cursor=helper.SelectData();

              while(cursor.moveToNext()){
                  uid=cursor.getString(1);
                  title=cursor.getString(2);
                  description=cursor.getString(3);

                  noteList.add(new Note(uid, title, description));
              }

              NoteAdapter adapter = new NoteAdapter(MainActivity.this, noteList);
              listview.setAdapter(adapter);
              cursor.close();
          }
      });
    }

}