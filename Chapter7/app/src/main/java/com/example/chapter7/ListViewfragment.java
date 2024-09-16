package com.example.chapter7;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

public class ListViewfragment extends Fragment {
    public ListViewfragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview,container,false);
        ListView listview = view.findViewById(R.id.showdata);
        TextView textview = view.findViewById(R.id.nodata);

        StudentDBHelper helper = new StudentDBHelper(getContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        String [] columns = new String[]{"_id","email","name"};
        Cursor cursor =db.query("students",columns,null,null,null,null,null);
        if(cursor.getCount()!=0){
            textview.setVisibility(View.INVISIBLE);
        }
        String[] from = new String[]{"name","email"};
        int [] to ={R.id.name,R.id.email};
        SimpleCursorAdapter cursoradapter = new SimpleCursorAdapter(getContext(),R.layout.itemview,cursor,from,to);
        listview.setAdapter(cursoradapter);
        return view;
    }
}
