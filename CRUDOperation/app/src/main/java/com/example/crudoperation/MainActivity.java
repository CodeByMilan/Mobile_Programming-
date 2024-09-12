package com.example.crudoperation;

import android.database.Cursor;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText id , name , address;
    private Button insert , select ,update ,delete;
   // private TextView showdata;
private ListView listview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        //showdata=findViewById(R.id.showdata);
        listview=findViewById(R.id.listview);

        insert=findViewById(R.id.insert);
        select=findViewById(R.id.select);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);

        StudentDBHelper helper= new StudentDBHelper(this);

       insert.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String sid = id.getText().toString();
               String sname = name.getText().toString();
               String saddress = address.getText().toString();

               helper.InsertData(sid,sname,saddress);

               Toast.makeText(MainActivity.this,"Data Inserted Succssfylly",Toast.LENGTH_SHORT).show();
           }
       });

       select.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String id = "";
               String name = "";
               String address = "";

               ArrayList<Student> studentList = new ArrayList<>();

               Cursor cursor=helper.SelectData();

               while(cursor.moveToNext()){
                    id=cursor.getString(0);
                    name=cursor.getString(1);
                    address=cursor.getString(2);

                   studentList.add(new Student(id, name, address));
               }
               //showdata.setText("Id:"+id+"Name :"+name+"Address:"+address);
               StudentAdapter adapter = new StudentAdapter(MainActivity.this, studentList);
               listview.setAdapter(adapter);
               cursor.close();

           }
       });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String sid = id.getText().toString();
             String sname = name.getText().toString();
             String saddress = address.getText().toString();

             helper.UpdateData(sid,sname,saddress);
                Toast.makeText(MainActivity.this,"Data Updated Succssfylly",Toast.LENGTH_SHORT).show();
    }
});
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String sid = id.getText().toString();
                    helper.DeleteData(sid);
                Toast.makeText(MainActivity.this,"Data Deleted Succssfylly",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
