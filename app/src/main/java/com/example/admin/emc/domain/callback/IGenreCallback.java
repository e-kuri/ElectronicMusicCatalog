package com.example.admin.emc.domain.callback;

import com.example.admin.emc.data.model.Genre;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;

import java.util.List;

/**
 * Created by admin on 8/9/2016.
 */
public interface IGenreCallback {

    public interface GenreListCallback{
        void onSuccess(Query query);
        void onError(DatabaseError error);
    }

}
