package com.example.admin.emc.data.Firebase;

import com.example.admin.emc.data.DAO.GenreDao;
import com.example.admin.emc.data.model.Genre;
import com.example.admin.emc.domain.adapter.builder.Exception.AdapterBuilderException;
import com.example.admin.emc.domain.adapter.builder.FirebaseAdapterBuilder;
import com.example.admin.emc.domain.adapter.builder.properties.AdapterBuilderProperties;
import com.example.admin.emc.domain.adapter.builder.properties.FirebaseAdapterBuilderProperties;
import com.example.admin.emc.domain.callback.IGenreCallback;
import com.example.admin.emc.domain.service.exception.ServiceException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.List;

/**
 * Created by admin on 7/26/2016.
 */
public class GenreDAOFirebaseImpl implements GenreDao {

    private DatabaseReference db = FirebaseDatabase.getInstance().getReference().child(GenreDao.TABLE_NAME);
/*
    private static GenreDAOFirebaseImpl instance;

    private GenreDAOFirebaseImpl(){}

    public static GenreDAOFirebaseImpl getInstance(){
        if(instance == null)
            instance = new GenreDAOFirebaseImpl();

        return instance;
    }
*/
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
}
