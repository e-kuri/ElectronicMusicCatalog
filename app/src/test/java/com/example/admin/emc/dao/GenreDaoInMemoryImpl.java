package com.example.admin.emc.dao;

import android.support.annotation.VisibleForTesting;

import com.example.admin.emc.data.DAO.GenreDao;
import com.example.admin.emc.data.model.Genre;
import com.example.admin.emc.domain.adapter.builder.properties.ArrayAdapterProperties;
import com.example.admin.emc.domain.callback.IGenreCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 8/17/2016.
 */
public class GenreDaoInMemoryImpl implements GenreDao {

    @VisibleForTesting
    List<Genre> mCachedGenres;

    @Override
    public void insertGenre(Genre genre) {

    }

    @Override
    public void deleteGenre(String genre) {

    }

    @Override
    public void getGenreByName(String genre) {

    }

    @Override
    public void getAllGenres(IGenreCallback.GenreListDbCallback callback) {
        ArrayAdapterProperties properties = new ArrayAdapterProperties();
        if(mCachedGenres == null){
            mCachedGenres = new ArrayList<Genre>();
            for(Genre.GenreName genreName : Genre.GenreName.values()){
                Genre genre = new Genre();
                genre.setGenre(genreName.toString());
                switch (genreName){
                    case TECHNO:
                        genre.setImageUrl("https://i.ytimg.com/vi/-TlQIFKot_0/hqdefault.jpg");
                        break;
                    case HOUSE:
                        genre.setImageUrl("http://orig12.deviantart.net/7de4/f/2010/011/e/9/house_music_by_labelrx.png");
                        break;
                    case DUBSTEP:
                        genre.setImageUrl("https://images4.alphacoders.com/244/244286.jpg");
                        break;
                    case TRANCE:
                        genre.setImageUrl("http://factmag-images.s3.amazonaws.com/wp-content/uploads/2015/12/trance3-12.11.2015.png");
                        break;
                }
                mCachedGenres.add(genre);
            }
        }
        properties.setContent(mCachedGenres);
        callback.onSuccess(properties);
    }
}
