package com.example.admin.emc.db.DAO;

import android.database.Cursor;

import com.example.admin.emc.model.Genre;

import java.util.List;

/**
 * Created by admin on 7/24/2016.
 */
public interface GenreDao {
    String TABLE_NAME = "GENRE";

    void insertGenre(Genre genre);
    void deleteGenre(String genre);
    void getGenreByName(String genre);
    List<Genre> GetAllGenres();
}
