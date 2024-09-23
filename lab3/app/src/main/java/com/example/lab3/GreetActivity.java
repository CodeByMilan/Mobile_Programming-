package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GreetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greetactivity);
        Intent i = getIntent();
        String name = i.getStringExtra("name");

        TextView textView =findViewById(R.id.showtext);
        textView.setText("hello "+name);
    }
}
