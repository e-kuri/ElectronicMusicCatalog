package com.example.admin.electronicmusiccatalog;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin on 7/13/2016.
 */
public class DJHolder extends ViewHolder
{
    public TextView name, description;
    public ImageView image;


    public DJHolder(View itemView) {
        super(itemView);
        name = ((TextView) itemView.findViewById(R.id.name));
        description = ((TextView) itemView.findViewById(R.id.description));
        image = ((ImageView) itemView.findViewById(R.id.image));
    }
}
