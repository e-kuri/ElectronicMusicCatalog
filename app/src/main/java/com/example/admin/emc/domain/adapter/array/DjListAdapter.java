package com.example.admin.emc.domain.adapter.array;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.emc.R;
import com.example.admin.emc.data.model.DJ;
import com.example.admin.emc.domain.adapter.builder.properties.ArrayAdapterProperties;

import java.util.List;

/**
 * Created by admin on 8/22/2016.
 */
public class DjListAdapter extends RecyclerView.Adapter<DjListAdapter.ViewHolder>{

    private List<DJ> djs;

    public DjListAdapter(ArrayAdapterProperties properties) {
        this.djs = properties.getContent();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(djs.get(position).getName());
        holder.nationality.setText(djs.get(position).getNationality());
    }

    @Override
    public int getItemCount() {
        return djs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name, nationality;

        public ViewHolder(View itemView) {
            super(itemView);
            name = ((TextView) itemView.findViewById(R.id.dj_name));
            nationality = ((TextView) itemView.findViewById(R.id.dj_nationality));
        }
    }
}
