package com.example.admin.emc.data.DAO;

import com.example.admin.emc.data.model.Genre;
import com.example.admin.emc.domain.callback.IGenreCallback;

import java.util.List;

/**
 * Created by admin on 7/24/2016.
 */
public interface GenreDao {
    String TABLE_NAME = "GENRE";

    void insertGenre(Genre genre);
    void deleteGenre(String genre);
    void getGenreByName(String genre);
    void GetAllGenres(IGenreCallback.GenreListCallback callback);
}
