package com.example.emailviewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MailAdapter extends RecyclerView.Adapter<MailViewHolder> {
    private List<EmailItems> items;
    public MailAdapter(List<EmailItems>emailItemsList){
        this.items=emailItemsList;
    }
    @NonNull
    @Override
    public MailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemslist,parent,false);
        return new MailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MailViewHolder holder, int position) {
        EmailItems currentposition = items.get(position);
        holder.initial.setText(currentposition.getTitleInitial());
        holder.title.setText(currentposition.getTitle());
        holder.title.setText(currentposition.getDescription());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
class MailViewHolder extends RecyclerView.ViewHolder{
    public  TextView initial,title,description;
    public MailViewHolder(View itemview){
        super(itemview);

        initial =itemview.findViewById(R.id.titleinitial);
        title = itemview.findViewById(R.id.name);
         description = itemview.findViewById(R.id.description);


    }

}