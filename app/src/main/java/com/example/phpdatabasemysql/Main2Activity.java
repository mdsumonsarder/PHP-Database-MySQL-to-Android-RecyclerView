package com.example.phpdatabasemysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //ImageLoad;
        imageView = findViewById(R.id.next);
        String link = getIntent().getStringExtra("img");
        Picasso.get().load(link).into(imageView);


    }
}
