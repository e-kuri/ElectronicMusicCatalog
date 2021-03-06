package com.example.admin.emc.domain.adapter.firebase;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.admin.emc.R;
import com.example.admin.emc.data.model.Genre;
import com.example.admin.emc.domain.adapter.builder.AdapterBuilder;
import com.example.admin.emc.domain.adapter.builder.AdapterListener;
import com.google.firebase.database.Query;

/**
 * Created by admin on 7/27/2016.
 */
public class FirebaseGenreAdapter extends FirebaseRecyclerAdapter<Genre, FirebaseGenreAdapter.ViewHolder>{

    //private int width, height;

    Listener listener;

    public static interface Listener extends AdapterListener{
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

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

}
