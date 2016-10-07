package com.example.elvira.mygallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView my_recycler_view;
    List<String> photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photo = new LinkedList<>();
        for (int i = 0; i < 13 ; i++) {
            photo.add("image"+i);
        }

        my_recycler_view= (RecyclerView) findViewById(R.id.my_recycler_view);
        my_recycler_view.setLayoutManager(new GridLayoutManager(this,2));
        my_recycler_view.setAdapter(new GalleryAdapter(photo));
    }

    private class GalleryAdapter extends RecyclerView.Adapter<GalleryViewHolder>{
        List<String> myList;
        public GalleryAdapter(List<String> mList){
            this.myList=mList;
        }

        @Override
        public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_image,parent,false);
            return new GalleryViewHolder(view);
        }

        @Override
        public void onBindViewHolder(GalleryViewHolder holder, final int position) {

            try {

                final int myGalleryImage = getResources().getIdentifier("image" + position, "drawable", getPackageName());


                Picasso.with(MainActivity.this)
                        .load(myGalleryImage)
                        .error( R.drawable.image10)
                        .into(holder.getImage());

                holder.getImage().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MainActivity.this, MyGallery_Image.class);
                        intent.putExtra("image",myGalleryImage );
                        startActivity(intent);
                    }
                });
            }catch (OutOfMemoryError er){
            }
        }

        @Override
        public int getItemCount() {
            return myList.size();
        }

    }



}
