package com.example.emailviewer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EmailDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_detail);

        TextView initialTextView = findViewById(R.id.initial);
        TextView titleTextView = findViewById(R.id.name);
        TextView descriptionTextView = findViewById(R.id.description);

        // Retrieve the data passed from MainActivity
        Intent intent = getIntent();
        String initial = intent.getStringExtra("initial");
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");

        // Set the data to the TextViews
        initialTextView.setText(initial);
        titleTextView.setText(title);
        descriptionTextView.setText(description);
    }
}
