package com.example.admin.emc;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.emc.model.DJ;
import com.google.firebase.database.Query;

/**
 * Created by admin on 7/25/2016.
 */
public class FirebaseDJAdapter extends FirebaseRecyclerAdapter<DJ, DJHolder> {


    public FirebaseDJAdapter(int modelLayout, Query ref){
        super(DJ.class, modelLayout, DJHolder.class, ref);
    }

    @Override
    protected void populateViewHolder(DJHolder viewHolder, DJ model, int position) {
        viewHolder.name.setText(model.getName());
        viewHolder.description.setText(model.getNationality());
        Glide.with(viewHolder.image.getContext()).load(model.getImageURL()).override(600,400).into(viewHolder.image);
    }
}
