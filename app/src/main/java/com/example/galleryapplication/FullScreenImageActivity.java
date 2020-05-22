package com.example.galleryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;

public class FullScreenImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        getSupportActionBar().setTitle("View Photo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        ImageAdapter adapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(adapter.images[position]);
    }
}
