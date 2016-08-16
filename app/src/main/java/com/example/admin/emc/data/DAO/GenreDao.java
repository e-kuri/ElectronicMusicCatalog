package com.example.admin.emc.data.DAO;

import com.example.admin.emc.data.model.Genre;
import com.example.admin.emc.domain.adapter.builder.Exception.AdapterBuilderException;
import com.example.admin.emc.domain.callback.IGenreCallback;
import com.example.admin.emc.domain.service.exception.ServiceException;

import java.util.List;

/**
 * Created by admin on 7/24/2016.
 */
public interface GenreDao {
    String TABLE_NAME = "GENRE";

    void insertGenre(Genre genre);
    void deleteGenre(String genre);
    void getGenreByName(String genre);
    void getAllGenres(IGenreCallback.GenreListDbCallback callback);
}
