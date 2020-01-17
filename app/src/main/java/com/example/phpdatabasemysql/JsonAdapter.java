package com.example.phpdatabasemysql;

import android.content.Context;
import android.content.Intent;
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

    //Myclick Instance create;
    Myclick myclick;

    public JsonAdapter() {
    }

    public JsonAdapter(ArrayList<JsonDataList> list, Context context,Myclick myclick) {
        this.list = list;
        this.context = context;
        this.myclick = myclick;
    }


    @NonNull
    @Override
    public JsonDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {

        final View view = LayoutInflater.from(context).inflate(R.layout.per_row,parent,false);
        final JsonDataViewHolder jsonDataViewHolder = new JsonDataViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myclick.onClickMe(view,jsonDataViewHolder.getPosition());
            }
        });

        return jsonDataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JsonDataViewHolder holder, int position) {

        final JsonDataList currentdata = list.get(position);

        holder.name.setText(currentdata.getUser_name());
        holder.description.setText(currentdata.getUser_description());
        Picasso.get().load(currentdata.getUser_img()).into(holder.iamgeView);




        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Main2Activity.class);
                intent.putExtra("img",currentdata.getUser_img());
                context.startActivity(intent);
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
