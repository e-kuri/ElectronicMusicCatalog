package com.example.admin.emc.domain.adapter.array;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.admin.emc.R;
import com.example.admin.emc.data.model.Genre;
import com.example.admin.emc.domain.adapter.builder.properties.ArrayAdapterProperties;

import java.util.List;

/**
 * Created by admin on 8/14/2016.
 */
public class GenreListAdapter extends RecyclerView.Adapter<GenreListAdapter.ViewHolder> {

    private List<Genre> genres;

    public GenreListAdapter(List<Genre> genres){
        this.genres = genres;
    }

    public GenreListAdapter(ArrayAdapterProperties properties){
        this.genres = properties.getContent();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(holder.genreImage.getContext()).load(genres.get(position).getImageUrl()).fitCenter().into(holder.genreImage);
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView genreImage;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            genreImage = ((ImageView) itemView.findViewById(R.id.genreImage));
            cardView = ((CardView) itemView.findViewById(R.id.genre_card));
        }
    }
}
