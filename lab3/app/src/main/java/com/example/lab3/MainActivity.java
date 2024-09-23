package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

         name = findViewById(R.id.name);
         submit= findViewById(R.id.btn);

         submit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String input = name.getText().toString();
                 Intent i = new Intent(MainActivity.this,GreetActivity.class);
                 i.putExtra("name",input);
                 startActivity(i);
             }
         });
    }
}