package com.example.admin.emc.domain.di.module;

import com.example.admin.emc.data.DAO.GenreDao;
import com.example.admin.emc.data.Firebase.GenreDAOFirebaseImpl;
import com.example.admin.emc.domain.EMCApplication;
import com.example.admin.emc.domain.di.component.DaggerGenreComponent;
import com.example.admin.emc.domain.service.GenreServiceImpl;
import com.example.admin.emc.domain.service.IService.IGenreService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 8/15/2016.
 */
@Module
public class GenreModule {

    @Provides @Singleton static GenreDao provideGenreDao(){
        return new GenreDAOFirebaseImpl();
    }

    @Provides @Singleton static IGenreService provideGenreService(){
        return new GenreServiceImpl(provideGenreDao()g);
    }


}
