package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button submit;
    private RadioGroup rg;
    private EditText name,age,phone_number,email;
    private RadioButton r1,r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        rg=findViewById(R.id.rgroup);
        r1=findViewById(R.id.rmale);
        r2=findViewById(R.id.rfemale);
        age=findViewById(R.id.age);
        phone_number=findViewById(R.id.number);
        email=findViewById(R.id.email);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname =name.getText().toString();
                int sage;
                try {
                    sage = Integer.parseInt(age.getText().toString());
                } catch (NumberFormatException e) {
                    age.setError("Please enter a valid age");
                    return;
                }

                String number = phone_number.getText().toString();
                String semail =email.getText().toString();

                String gender = "";
                int selectedId = rg.getCheckedRadioButtonId();
                if (selectedId == r1.getId()) {
                    gender = "Male";
                } else if (selectedId == r2.getId()) {
                    gender = "Female";
                }
                if (validateInputs(sname, sage, number, semail, gender)) {
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    i.putExtra("name", sname);
                    i.putExtra("age", sage);
                    i.putExtra("email", semail);
                    i.putExtra("gender", gender);
                    i.putExtra("number", number);
                    startActivity(i);
                }
            }
        });

    }
    private boolean validateInputs(String sname, int sage, String number, String semail, String gender) {
        if (sname == null || sname.isEmpty() || !sname.matches("[A-Za-z]+\\s[A-Za-z]+")) {
            name.setError("Please enter a valid name (FirstName LastName)");
            return false;
        }

        if (sage <= 0){
            age.setError("Please enter a valid age");
            return false;
        }

        if (rg.getCheckedRadioButtonId() == -1) {
            Toast.makeText(MainActivity.this, "Please select a gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (semail == null || semail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(semail).matches()) {
            email.setError("Please enter a valid email");
            return false;
        }

        if (number == null || number.isEmpty() || !number.matches("\\d+")|| number.length() != 10) {
            phone_number.setError("Please enter a valid phone number (digits only) and must be 10 digits ");
            return false;
        }

        return true;
    }
}

