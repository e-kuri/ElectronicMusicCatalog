package com.example.admin.emc.domain.callback;

import android.support.v7.widget.RecyclerView;

import com.example.admin.emc.data.model.DJ;
import com.example.admin.emc.domain.adapter.builder.properties.AdapterBuilderProperties;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;

import java.util.List;

/**
 * Created by admin on 8/8/2016.
 */
public interface IDJListCallback {

    interface DJListDbCallback{
        void onSuccess(AdapterBuilderProperties properties);
        void onError(Exception e);
    }

    interface DJListCallback{
        void onSuccess(RecyclerView.Adapter adapter);
        void onError(DatabaseError error);
    }

    interface DJListResultCallback{
        void onSuccess(List result);
        void onError(DatabaseError error);
    }

}
