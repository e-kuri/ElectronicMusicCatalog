package com.example.admin.emc.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.emc.R;
import com.example.admin.emc.model.DJ;
import com.example.admin.emc.model.Genre;
import com.google.firebase.database.Query;

/**
 * Created by admin on 7/28/2016.
 */
public class FirebaseDjListAdapter extends FirebaseRecyclerAdapter<DJ, FirebaseDjListAdapter.ViewHolder>{

    Listener listener;

    public static interface Listener{
        void onclick(String key);
    }

    public FirebaseDjListAdapter(int modelLayout, Query ref, Listener listener){
        super(DJ.class, modelLayout, FirebaseDjListAdapter.ViewHolder.class, ref);
        this.listener = listener;
    }

    @Override
    protected void populateViewHolder(ViewHolder viewHolder, DJ model, int position) {
        viewHolder.name.setText(model.getName());
        viewHolder.nationality.setText(model.getNationality());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout layout;
        public TextView name, nationality;

        public ViewHolder(View itemView) {
            super(itemView);
            layout = ((LinearLayout) itemView.findViewById(R.id.dj_list_layout));
            name = ((TextView) itemView.findViewById(R.id.dj_name));
            nationality = ((TextView) itemView.findViewById(R.id.dj_nationality));
        }
    }
}
