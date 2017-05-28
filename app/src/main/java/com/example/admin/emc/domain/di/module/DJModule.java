package com.example.admin.emc.domain.di.module;

import com.example.admin.emc.data.DAO.DjDao;
import com.example.admin.emc.data.Firebase.DJDaoFirebaseImpl;
import com.example.admin.emc.domain.EMCApplication;
import com.example.admin.emc.domain.di.component.DaggerGenreComponent;
import com.example.admin.emc.domain.service.DJServiceImpl;
import com.example.admin.emc.domain.service.IService.IDJService;
import com.example.admin.emc.presentation.presenter.DJListPresenter;
import com.example.admin.emc.presentation.presenter.IPresenter.DJListContract;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 8/17/2016.
 */
@Module
public class DJModule {

    @Provides @Singleton
    DjDao provideDJDao(){
        return new DJDaoFirebaseImpl();
    }

    @Provides @Singleton
    IDJService provideDJService(){
        return new DJServiceImpl(provideDJDao());
    }
/*
    @Provides @Singleton
    DJListContract.UserActionListener provideDJListPresenter(){
        return new DJListPresenter(provideDJService());
    }
*/
}
