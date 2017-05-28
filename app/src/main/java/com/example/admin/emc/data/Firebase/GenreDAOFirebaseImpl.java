package com.example.admin.emc.data.Firebase;

import com.example.admin.emc.data.DAO.DjDao;
import com.example.admin.emc.data.DAO.GenreDao;
import com.example.admin.emc.data.model.DJ;
import com.example.admin.emc.data.model.Genre;
import com.example.admin.emc.domain.EMCApplication;
import com.example.admin.emc.domain.adapter.builder.Exception.AdapterBuilderException;
import com.example.admin.emc.domain.adapter.builder.FirebaseAdapterBuilder;
import com.example.admin.emc.domain.adapter.builder.properties.AdapterBuilderProperties;
import com.example.admin.emc.domain.adapter.builder.properties.FirebaseAdapterBuilderProperties;
import com.example.admin.emc.domain.callback.IDJListCallback;
import com.example.admin.emc.domain.callback.IGenreCallback;
import com.example.admin.emc.domain.service.exception.ServiceException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by admin on 7/26/2016.
 */
public class GenreDAOFirebaseImpl implements GenreDao {

    private DatabaseReference db = FirebaseDatabase.getInstance().getReference().child(GenreDao.TABLE_NAME);
/*
    @Inject
    DjDao djDao;

    public GenreDAOFirebaseImpl(){
        this.djDao = EMCApplication.getDjComponent().getDao();
    }
*/
    /*private static GenreDAOFirebaseImpl instance;

    private GenreDAOFirebaseImpl(){}

    public static GenreDAOFirebaseImpl getInstance(){
        if(instance == null)
            instance = new GenreDAOFirebaseImpl();

        return instance;
    }*/

    @Override
    public void insertGenre(Genre genre) {
        String name = genre.getGenre();
        genre.setGenre(null);
        db.child(name).setValue(genre);
    }

    @Override
    public void deleteGenre(String genre) {

    }

    @Override
    public void getGenreByName(String genre) {

    }

    @Override
    public void getAllGenres(IGenreCallback.GenreListDbCallback callback) {
        Query lastFifty = db.limitToLast(50);
        FirebaseAdapterBuilderProperties properties = new FirebaseAdapterBuilderProperties();
        properties.setRef(lastFifty);
        callback.onSuccess(properties);
    }

    @Override
    public void insertDJ(String genre, String dj) {
        DatabaseReference ref = db.child(genre).child("djs");
        ref.child(dj).setValue(true);
    }

    public void getDJsByGenre(String genre, final IDJListCallback.DJListResultCallback callback){
        DatabaseReference ref = db.child(genre).child("djs");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<DJ> result = new ArrayList<>();
                DatabaseReference djRef = db.getParent().child(DjDao.TABLE_NAME);
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    db.child(postSnapshot.getKey()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            result.add(dataSnapshot.getValue(DJ.class));
                            callback.onSuccess(result);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            callback.onError(databaseError);
                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.onError(databaseError);
            }
        });
    }
}
