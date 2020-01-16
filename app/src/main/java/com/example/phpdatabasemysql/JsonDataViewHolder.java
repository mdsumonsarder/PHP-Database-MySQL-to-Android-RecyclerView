package com.example.phpdatabasemysql;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JsonDataViewHolder extends RecyclerView.ViewHolder {

    ImageView iamgeView;
    TextView name,description;
    public JsonDataViewHolder(@NonNull View itemView) {
        super(itemView);

        iamgeView = itemView.findViewById(R.id.row_img);
        name = itemView.findViewById(R.id.row_name);
        description = itemView.findViewById(R.id.row_des);

    }
}
