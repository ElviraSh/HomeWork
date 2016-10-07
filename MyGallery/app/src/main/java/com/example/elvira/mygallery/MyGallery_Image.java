package com.example.elvira.mygallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MyGallery_Image extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_gallery__image);


        image = (ImageView) findViewById(R.id.image);
        Picasso.with(this).load(getIntent().getIntExtra("image", getResources().getIdentifier("error", "drawable", getPackageName()))).into(image);
    }
}
