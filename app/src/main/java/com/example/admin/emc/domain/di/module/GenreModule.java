package com.example.admin.emc.domain.di.module;

import com.example.admin.emc.data.DAO.GenreDao;
import com.example.admin.emc.data.Firebase.GenreDAOFirebaseImpl;
import com.example.admin.emc.domain.callback.IGenreCallback;
import com.example.admin.emc.domain.service.GenreServiceImpl;
import com.example.admin.emc.domain.service.IService.IGenreService;
import com.example.admin.emc.presentation.presenter.GenrePresenter;
import com.example.admin.emc.presentation.presenter.IPresenter.GenreContract;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 8/15/2016.
 */
@Module
public class GenreModule {

    @Provides @Singleton GenreDao provideGenreDao(){
        return new GenreDAOFirebaseImpl();
    }

    @Provides @Singleton IGenreService provideGenreService(){
        return new GenreServiceImpl(provideGenreDao());
    }

    @Provides @Singleton GenreContract.UserActionListener provideGenrePresenter(){
        return new GenrePresenter(provideGenreService());
    }

}
