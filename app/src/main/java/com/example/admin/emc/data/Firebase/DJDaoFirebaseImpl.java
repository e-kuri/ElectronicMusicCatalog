package com.example.admin.emc.data.Firebase;

import com.example.admin.emc.data.DAO.DjDao;
import com.example.admin.emc.domain.callback.IDJCallback;
import com.example.admin.emc.data.model.DJ;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * Created by admin on 7/26/2016.
 */
public class DJDaoFirebaseImpl implements DjDao {

    private static DJDaoFirebaseImpl instance;
    private DatabaseReference db = FirebaseDatabase.getInstance().getReference().child(DjDao.TABLE_NAME);

    private DJDaoFirebaseImpl(){

    }

    @Override
    public void insertDJ(DJ dj) throws DatabaseException {
        if(dj.getUsername() == null || dj.getUsername().length() == 0)
            throw new DatabaseException("username is a mandatory field");

        String username = dj.getUsername();
        dj.setUsername(null);
        db.child(username).setValue(dj);
    }

    @Override
    public void deleteDJ(String username) {

    }

    @Override
    public void getDJByUsername(String username, final IDJCallback.DJDetailCallback callback) {
        DatabaseReference ref = db.child(username);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DJ dj = dataSnapshot.getValue(DJ.class);
                callback.onSuccess(dj);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.onError(databaseError);
            }
        });
    }

    @Override
    public List<DJ> getAllDJs() {
        return null;
    }

    @Override
    public void getDJsByGenre(String genre, IDJCallback.DJListCallback callback) {
        Query lastFifty = db.limitToLast(50);
        callback.onSuccess(lastFifty);
    }


    public static DJDaoFirebaseImpl getInstance(){
        if(instance == null)
            instance = new DJDaoFirebaseImpl();

        return instance;
    }

}
