package com.example.fragmentexample;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class SecondFragment extends Fragment {
    private EditText length , breadth;
    private Button area;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,container,false);
        length=view.findViewById(R.id.length);
        breadth = view.findViewById(R.id.breadth);
        //TextView showdata = view.findViewById(R.id.showarea);
        area=view.findViewById(R.id.area);
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int l , b ,r ;
                l = Integer.parseInt(length.getText().toString());
                b=Integer.parseInt(breadth.getText().toString());
                r=l*b;
               // showdata.setText("area :"+r);

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Area")
                        .setMessage("The area is: " + r)
                        .setPositiveButton("OK", null);

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        return view;
    }


    }

