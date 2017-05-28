package com.example.admin.emc.domain.adapter.firebase;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.emc.R;
import com.example.admin.emc.data.model.DJ;
import com.example.admin.emc.domain.adapter.builder.AdapterListener;
import com.google.firebase.database.Query;

/**
 * Created by admin on 7/28/2016.
 */
public class FirebaseDjListAdapter extends FirebaseRecyclerAdapter<DJ, FirebaseDjListAdapter.ViewHolder>{

    private Listener listener;

    public static interface Listener extends AdapterListener{
        void onclick(String key);
    }

    public FirebaseDjListAdapter(int modelLayout, Query ref, Listener listener){
        super(DJ.class, modelLayout, FirebaseDjListAdapter.ViewHolder.class, ref);
        this.listener = listener;
    }

    @Override
    protected void populateViewHolder(ViewHolder viewHolder, DJ model, final int position) {
        viewHolder.name.setText(model.getName());
        viewHolder.nationality.setText(model.getNationality());
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onclick(getItemKey(position));
            }
        });
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

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
