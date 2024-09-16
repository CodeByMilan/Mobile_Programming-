package com.example.fragmentexample;

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

public class FirstFragment extends Fragment {
        private EditText length , breadth;
        private Button perimeter;
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment1,container,false);
            length=view.findViewById(R.id.length);
            breadth = view.findViewById(R.id.breadth);
            TextView showdata = view.findViewById(R.id.showperimeter);
            perimeter=view.findViewById(R.id.perimeter);
            perimeter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int l , b ,r ;
                    l = Integer.parseInt(length.getText().toString());
                    b=Integer.parseInt(breadth.getText().toString());
                    r=2*(l+b);
                    showdata.setText("Perimeter :"+r);
                }
            });

            return view;
        }
    }


