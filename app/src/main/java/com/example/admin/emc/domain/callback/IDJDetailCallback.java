package com.example.admin.emc.domain.callback;

import com.example.admin.emc.data.model.DJ;
import com.google.firebase.database.DatabaseError;

/**
 * Created by admin on 8/17/2016.
 */
public interface IDJDetailCallback {

    public interface DJByUsernamePresenterCallback{
        void onSuccess(DJ dj);
        void onError(DatabaseError error);
    }

    public interface DJByUsernameDaoCallback{
        void onSuccess(DJ dj);
        void onError(DatabaseError error);
    }

}
