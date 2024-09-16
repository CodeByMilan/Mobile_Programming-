package com.example.chapter7;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class CreateStudent extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.create_student,container,false);
        EditText email=view.findViewById(R.id.email);
        EditText name = view.findViewById(R.id.name);
        Button add =view.findViewById(R.id.addstudent);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname =name.getText().toString();
                String semail= email.getText().toString();

                StudentDBHelper helper = new StudentDBHelper(getContext());
                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues values =new ContentValues();
                values.put("email",semail);
                values.put("name",sname);
                db.insert("students",null,values);
                Snackbar.make(view,"Student added successfully ",Snackbar.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
