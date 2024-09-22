package com.example.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter {
    private ArrayList<Note> notelist;
    public NoteAdapter(@NonNull Context context, ArrayList<Note>notelist) {
        super(context,0,notelist);
        this.notelist=notelist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem, parent, false);
        }

        Note note = (Note) getItem(position);

        TextView idView = convertView.findViewById(R.id.uid);
        TextView nameView = convertView.findViewById(R.id.title);
        TextView addressView = convertView.findViewById(R.id.description);

        idView.setText(String.valueOf(note.getUid()));
        nameView.setText(note.getTitle());
        addressView.setText(note.getDescription());

        return convertView;
    }
}
