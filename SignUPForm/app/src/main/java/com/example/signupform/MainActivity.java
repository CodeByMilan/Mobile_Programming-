package com.example.signupform;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView title ,showdata;
    private Button submit;
    private RadioGroup rg;
    private EditText name;
    private RadioButton r1,r2;
    private CheckBox c1,c2;
    private Spinner sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.name);
        submit=findViewById(R.id.submit);
        name = findViewById(R.id.name);
        rg=findViewById(R.id.rgroup);
        r1=findViewById(R.id.rmale);
        r2=findViewById(R.id.rfemale);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        sp=findViewById(R.id.spinner);
        showdata=findViewById(R.id.showdata);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String sname =name.getText().toString();
                String gender = "";
                int selectedId = rg.getCheckedRadioButtonId();
                if (selectedId == r1.getId()) {
                    gender = "Male";
                } else if (selectedId == r2.getId()) {
                    gender = "Female";
                }
                 String course =sp.getSelectedItem().toString();
                StringBuilder vechile = new StringBuilder();

                if (c1.isChecked()) {
                    vechile.append(" Car");
                }

                if (c2.isChecked()) {
                    vechile.append(" Bike");
                }
                String vechiles = vechile.toString().trim();

                showdata.setText("student name is "+sname+"\n gender is :"+gender+"\nvechiles :"+vechiles+"\ncourse selected :"+course);

            }
        });

    }
}
