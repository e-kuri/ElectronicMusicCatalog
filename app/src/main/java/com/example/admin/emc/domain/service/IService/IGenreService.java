package com.example.admin.emc.domain.service.IService;

import com.example.admin.emc.domain.adapter.builder.AdapterBuilder;
import com.example.admin.emc.domain.adapter.builder.AdapterListener;
import com.example.admin.emc.domain.adapter.builder.Exception.AdapterBuilderException;
import com.example.admin.emc.domain.callback.IGenreCallback;
import com.example.admin.emc.domain.service.exception.ServiceException;

/**
 * Created by admin on 8/14/2016.
 */
public interface IGenreService {

    void getAllGenresAdapter(int layout, AdapterListener listener, IGenreCallback.GenreListCallback callback) throws ServiceException, AdapterBuilderException;

}
