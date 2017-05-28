package com.example.admin.emc.domain.adapter.builder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.admin.emc.domain.adapter.array.DjListAdapter;
import com.example.admin.emc.domain.adapter.array.GenreListAdapter;
import com.example.admin.emc.domain.adapter.builder.AdapterBuilder;
import com.example.admin.emc.domain.adapter.builder.properties.ArrayAdapterProperties;

/**
 * Created by admin on 8/17/2016.
 */
public class ArrayAdapterBuilder extends AdapterBuilder {

    public ArrayAdapterBuilder(ArrayAdapterProperties properties){
        this.properties = properties;
    }

    @Override
    public RecyclerView.Adapter getAdapter(AdapterContent content) {
        RecyclerView.Adapter adapter = null;
        switch (content){
            case GENRE:
                adapter = new GenreListAdapter((ArrayAdapterProperties) properties);
            case DJ_LIST:
                adapter = new DjListAdapter((ArrayAdapterProperties) properties);
        }
        return adapter;
    }
}
