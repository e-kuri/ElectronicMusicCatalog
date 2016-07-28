package com.example.admin.emc.Adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.admin.emc.DJActivity;
import com.example.admin.emc.R;
import com.example.admin.emc.model.DJ;
import com.example.admin.emc.model.Genre;
import com.google.firebase.database.Query;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by admin on 7/27/2016.
 */
public class FirebaseGenreAdapter extends FirebaseRecyclerAdapter<Genre, FirebaseGenreAdapter.ViewHolder>{

    //private int width, height;

    Listener listener;

    public static interface Listener{
        void onclick(String key);
    }

    public FirebaseGenreAdapter(int modelLayout, Query ref, Listener listener){
        super(Genre.class, modelLayout, FirebaseGenreAdapter.ViewHolder.class, ref);
        //this.width = width;
        //this.height = height;
        this.listener = listener;
    }

    @Override
    protected void populateViewHolder(ViewHolder viewHolder, Genre model, int position) {
        Glide.with(viewHolder.genreImage.getContext()).load(model.getImageUrl()).fitCenter().into(viewHolder.genreImage);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        super.onBindViewHolder(viewHolder, position);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null)
                    listener.onclick(getItemKey(position));
            }
        });
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView genreImage;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            genreImage = ((ImageView) itemView.findViewById(R.id.genreImage));
            cardView = ((CardView) itemView.findViewById(R.id.genre_card));
        }
    }

}
