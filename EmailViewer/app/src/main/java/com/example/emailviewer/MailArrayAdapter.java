package com.example.emailviewer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class MailArrayAdapter extends ArrayAdapter<EmailItems> {
    private List<EmailItems> items;

    public MailArrayAdapter(@NonNull Context context, List<EmailItems>items) {
        super(context,R.layout.itemslist,items);
        this.items=items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      if(convertView==null){
          convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemslist,parent,false);
      }
        TextView initial = convertView.findViewById(R.id.titleinitial);
      TextView title = convertView.findViewById(R.id.name);
      TextView description = convertView.findViewById(R.id.description);


        EmailItems currentposition = items.get(position);

      initial.setText(currentposition.getTitleInitial());
      title.setText(currentposition.getTitle());
      description.setText(currentposition.getDescription());
      return convertView;
    }
}
