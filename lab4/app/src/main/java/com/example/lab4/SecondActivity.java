package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView name , age , gender , email,number ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        name=findViewById(R.id.name);
        age = findViewById(R.id.age);
        gender=findViewById(R.id.gender);
        email=findViewById(R.id.email);
        number=findViewById(R.id.number);

        Intent i =getIntent();
        name.setText(i.getStringExtra("name"));
        age.setText(String.valueOf(i.getIntExtra("age",10)));
        gender.setText(i.getStringExtra("gender"));
        email.setText(i.getStringExtra("email"));
        number.setText(i.getStringExtra("number"));
    }
}
