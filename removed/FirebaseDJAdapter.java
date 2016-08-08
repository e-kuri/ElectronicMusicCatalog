package com.example.admin.emc.domain.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.emc.R;
import com.example.admin.emc.data.model.DJ;
import com.google.firebase.database.Query;

/**
 * Created by admin on 7/25/2016.
 */
public class FirebaseDJAdapter extends FirebaseRecyclerAdapter<DJ, FirebaseDJAdapter.ViewHolder> {


    public FirebaseDJAdapter(int modelLayout, Query ref){
        super(DJ.class, modelLayout, FirebaseDJAdapter.ViewHolder.class, ref);
    }

    @Override
    protected void populateViewHolder(FirebaseDJAdapter.ViewHolder viewHolder, DJ model, int position) {
        viewHolder.name.setText(model.getName());
        viewHolder.description.setText(model.getNationality());
        Glide.with(viewHolder.image.getContext()).load(model.getImageURL()).override(600,400).into(viewHolder.image);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView name, description;
        public ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            name = ((TextView) itemView.findViewById(R.id.name));
            description = ((TextView) itemView.findViewById(R.id.description));
            image = ((ImageView) itemView.findViewById(R.id.image));
        }
    }
}
