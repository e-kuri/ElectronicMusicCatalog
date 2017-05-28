package com.example.admin.emc.data.Firebase;

import android.util.Log;

import com.example.admin.emc.data.DAO.DjDao;
import com.example.admin.emc.data.DAO.GenreDao;
import com.example.admin.emc.domain.EMCApplication;
import com.example.admin.emc.domain.adapter.builder.properties.ArrayAdapterProperties;
import com.example.admin.emc.domain.adapter.builder.properties.FirebaseAdapterBuilderProperties;
import com.example.admin.emc.domain.callback.IDJDetailCallback;
import com.example.admin.emc.domain.callback.IDJListCallback;
import com.example.admin.emc.data.model.DJ;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by admin on 7/26/2016.
 */
public class DJDaoFirebaseImpl implements DjDao {

    @Inject
    GenreDao genreDao;

    public DJDaoFirebaseImpl(){
        this.genreDao = EMCApplication.getGenreComponent().getDao();
    }

    private DatabaseReference db = FirebaseDatabase.getInstance().getReference().child(DjDao.TABLE_NAME);

    @Override
    public void insertDJ(DJ dj) throws DatabaseException {
        if(dj.getUsername() == null || dj.getUsername().length() == 0)
            throw new DatabaseException("username is a mandatory field");

        String username = dj.getUsername();
        dj.setUsername(null);
        db.child(username).setValue(dj);

        Iterator it = dj.getGenres().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            if((Boolean) entry.getValue() == true)
                genreDao.insertDJ(entry.getKey().toString(), username);
        }
    }

    @Override
    public void deleteDJ(String username) {

    }

    @Override
    public void getDJByUsername(String username, final IDJDetailCallback.DJByUsernameDaoCallback callback) {
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
    public void getDJsByGenre(String genre, final IDJListCallback.DJListDbCallback callback) {
        //Query genreQuery = genreDao.getDJsByGenre(genre);
        FirebaseAdapterBuilderProperties properties = new FirebaseAdapterBuilderProperties();
        properties.setRef(db);

        callback.onSuccess(properties);
/*
        genreDao.getDJsByGenre(genre, new IDJListCallback.DJListResultCallback() {
            @Override
            public void onSuccess(List result) {
                ArrayAdapterProperties properties = new ArrayAdapterProperties(result);
                callback.onSuccess(properties);
            }

            @Override
            public void onError(DatabaseError error) {
                Log.e("DjDaoFirebaseImpl", error.getDetails());
            }
        });*/
    }

}
