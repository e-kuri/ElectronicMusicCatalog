package com.example.admin.emc.domain.service;

import com.example.admin.emc.data.DAO.GenreDao;
import com.example.admin.emc.domain.adapter.builder.AdapterBuilder;
import com.example.admin.emc.domain.adapter.builder.AdapterListener;
import com.example.admin.emc.domain.adapter.builder.Exception.AdapterBuilderException;
import com.example.admin.emc.domain.adapter.builder.properties.AdapterBuilderProperties;
import com.example.admin.emc.domain.callback.IGenreCallback;
import com.example.admin.emc.domain.service.IService.IGenreService;
import com.example.admin.emc.domain.service.exception.ServiceException;

import javax.inject.Inject;

/**
 * Created by admin on 8/14/2016.
 */
public class GenreServiceImpl implements IGenreService {
/*
    private static GenreServiceImpl instance;

    private GenreServiceImpl(){ }

    public static GenreServiceImpl getInstance(){
        if (instance == null)
            instance = new GenreServiceImpl();
        return instance;
    }
*/
    private final GenreDao genreDao;

    @Inject
    public GenreServiceImpl(GenreDao genreDao){
        this.genreDao = genreDao;
    }

    @Override
    public void getAllGenresAdapter(final int layout, final AdapterListener listener, final IGenreCallback.GenreListCallback callback) throws ServiceException, AdapterBuilderException {
        genreDao.getAllGenres(new IGenreCallback.GenreListDbCallback() {
            @Override
            public void onSuccess(AdapterBuilderProperties properties) {
                try {
                    properties.setModelLayout(layout);
                    properties.setListener(listener);
                    callback.onSuccess(AdapterBuilder.getBuilder(properties).getAdapter(AdapterBuilder.AdapterContent.GENRE));
                } catch (AdapterBuilderException e) {
                    onError(e);
                }
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
            }
        });
    }
}
