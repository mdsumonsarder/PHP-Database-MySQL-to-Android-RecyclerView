package com.example.phpdatabasemysql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class JsonAdapter extends RecyclerView.Adapter<JsonDataViewHolder> {

    ArrayList<JsonDataList> list;
    Context context;

    public JsonAdapter() {
    }

    public JsonAdapter(ArrayList<JsonDataList> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public JsonDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.per_row,parent,false);

        return new JsonDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JsonDataViewHolder holder, int position) {

        JsonDataList currentdata = list.get(position);
        holder.name.setText(currentdata.getUser_name());
        holder.description.setText(currentdata.getUser_description());
        Picasso.get().load(currentdata.getUser_img()).into(holder.iamgeView);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
