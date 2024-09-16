package com.example.chapter7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public  class MainActivity extends AppCompatActivity{

private TextInputEditText nametxt ;
private TextInputEditText passwordtxt;
private Button submitbutton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     nametxt =findViewById(R.id.name);
     passwordtxt=findViewById(R.id.password);
     submitbutton=findViewById(R.id.btn);

     submitbutton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String name = nametxt.getText().toString();
            String password = passwordtxt.getText().toString();

            //for validation set name and passsword as
             String loginname ="Milan";
             String loginpassword="12";

             if((loginname.equals(name))&&(loginpassword.equals(password))){
                 //used to print the on the login page
                 Snackbar.make(findViewById(R.id.mainlayout),"You are Logged in !!", Toast.LENGTH_SHORT).show();

                 Intent intent=new Intent(MainActivity.this,LoginPage.class);
                 intent.putExtra("name",name);
                 startActivity(intent);

             }
             else {
                 Snackbar.make(findViewById(R.id.mainlayout),"Wrong username or password !! ", Toast.LENGTH_SHORT).show();

             }

         }
     });


    }
}