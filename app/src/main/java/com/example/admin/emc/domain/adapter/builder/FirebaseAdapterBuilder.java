package com.example.admin.emc.domain.adapter.builder;

import android.support.v7.widget.RecyclerView;

import com.example.admin.emc.domain.adapter.builder.properties.AdapterBuilderProperties;
import com.example.admin.emc.domain.adapter.builder.properties.FirebaseAdapterBuilderProperties;
import com.example.admin.emc.domain.adapter.firebase.FirebaseDjListAdapter;
import com.example.admin.emc.domain.adapter.firebase.FirebaseGenreAdapter;
import com.google.firebase.database.Query;

/**
 * Created by admin on 8/14/2016.
 */
public class FirebaseAdapterBuilder extends AdapterBuilder {

    public FirebaseAdapterBuilder(FirebaseAdapterBuilderProperties properties){
        this.properties = properties;
    }

    @Override
    public RecyclerView.Adapter getAdapter(AdapterContent content) {
        RecyclerView.Adapter adapter = null;
        switch (content){
            case DJ_LIST:
                adapter = new FirebaseDjListAdapter(((FirebaseAdapterBuilderProperties)properties).getModelLayout(),
                        ((FirebaseAdapterBuilderProperties)properties).getRef(),
                        (FirebaseDjListAdapter.Listener) ((FirebaseAdapterBuilderProperties)properties).getListener());
                break;
            case GENRE:
                adapter = new FirebaseGenreAdapter(((FirebaseAdapterBuilderProperties)properties).getModelLayout(),
                        ((FirebaseAdapterBuilderProperties)properties).getRef(),
                        (FirebaseGenreAdapter.Listener) ((FirebaseAdapterBuilderProperties)properties).getListener());
                break;
        }
        return adapter;
    }
}
