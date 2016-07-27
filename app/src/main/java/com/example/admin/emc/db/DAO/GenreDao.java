package com.example.admin.emc.db.DAO;

import android.database.Cursor;

import com.example.admin.emc.model.Genre;

/**
 * Created by admin on 7/24/2016.
 */
public interface GenreDao {
    String TABLE_NAME = "GENRE";

    enum Columns{
        _id, GENRE
    }

    void insertGenre(Genre genre);
    void deleteGenre(Genre genre);
    void getGenreById(int idGenre);
    Cursor getAllGenresForCursor();
}
