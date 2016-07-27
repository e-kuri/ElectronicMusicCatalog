package com.example.admin.emc.db.Firebase;

import com.example.admin.emc.db.DAO.GenreDao;
import com.example.admin.emc.model.Genre;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by admin on 7/26/2016.
 */
public class GenreDAOFirebaseImpl implements GenreDao {

    private static GenreDAOFirebaseImpl instance;
    private DatabaseReference db = FirebaseDatabase.getInstance().getReference().child(GenreDao.TABLE_NAME);

    private GenreDAOFirebaseImpl(){}

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
    public List<Genre> GetAllGenres() {
        return null;
    }

    public static GenreDAOFirebaseImpl getInstance(){
        if(instance == null)
            instance = new GenreDAOFirebaseImpl();

        return instance;
    }
}
