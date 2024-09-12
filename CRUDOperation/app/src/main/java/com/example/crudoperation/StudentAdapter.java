package com.example.crudoperation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter {

    private ArrayList<Student> studentList;

    public StudentAdapter(Context context, ArrayList<Student> studentList) {
        super(context,0,studentList);
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview, parent, false);
        }

        Student student = (Student) getItem(position);

        TextView idView = convertView.findViewById(R.id.id);
        TextView nameView = convertView.findViewById(R.id.name);
        TextView addressView = convertView.findViewById(R.id.address);

        idView.setText(String.valueOf(student.getId()));
        nameView.setText(student.getName());
        addressView.setText(student.getAddress());

        return convertView;
    }
}
