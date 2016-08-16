package com.example.admin.emc.domain.callback;

import android.support.v7.widget.RecyclerView;

import com.example.admin.emc.data.model.Genre;
import com.example.admin.emc.domain.adapter.builder.AdapterBuilder;
import com.example.admin.emc.domain.adapter.builder.Exception.AdapterBuilderException;
import com.example.admin.emc.domain.adapter.builder.properties.AdapterBuilderProperties;
import com.example.admin.emc.domain.service.exception.ServiceException;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;

import java.util.List;

/**
 * Created by admin on 8/9/2016.
 */
public interface IGenreCallback {

    public interface GenreListCallback{
        void onSuccess(RecyclerView.Adapter adapter);
        void onError(DatabaseError error);
    }

    public interface GenreListDbCallback{
        void onSuccess(AdapterBuilderProperties properties);
        void onError(Exception e);
    }

}
