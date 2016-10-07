package com.example.elvira.mygallery;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Elvira on 07.10.2016.
 */
class GalleryViewHolder extends RecyclerView.ViewHolder {
    ImageView image_v;

    public GalleryViewHolder(View itemView) {
        super(itemView);
        image_v = (ImageView) itemView.findViewById(R.id.image_v);
    }

    public ImageView getImage(){
        return image_v;
    }
}
