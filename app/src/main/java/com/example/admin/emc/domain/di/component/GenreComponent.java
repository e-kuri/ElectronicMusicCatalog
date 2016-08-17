package com.example.admin.emc.domain.di.component;

import com.example.admin.emc.data.DAO.GenreDao;
import com.example.admin.emc.domain.di.module.GenreModule;
import com.example.admin.emc.domain.service.IService.IGenreService;
import com.example.admin.emc.presentation.presenter.GenrePresenter;
import com.example.admin.emc.presentation.presenter.IPresenter.GenreContract;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by admin on 8/15/2016.
 */
@Singleton
@Component(modules = GenreModule.class)
public interface GenreComponent {
    IGenreService getService();
    GenreDao getDao();

    //void injectIntoPresenter(GenreContract.UserActionListener presenter);
}
