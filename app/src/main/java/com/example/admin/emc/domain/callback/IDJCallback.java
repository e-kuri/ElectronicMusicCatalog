package com.example.admin.emc.domain.callback;

import com.example.admin.emc.data.model.DJ;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;

/**
 * Created by admin on 8/8/2016.
 */
public interface IDJCallback {

    public interface DJListCallback{
        void onSuccess(Query query);
        void onError(DatabaseError error);
    }

    public interface DJDetailCallback{
        void onSuccess(DJ dj);
        void onError(DatabaseError error);
    }

}
