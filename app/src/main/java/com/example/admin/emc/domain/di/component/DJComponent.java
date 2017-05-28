package com.example.admin.emc.domain.di.component;

import com.example.admin.emc.data.DAO.DjDao;
import com.example.admin.emc.domain.di.module.DJModule;
import com.example.admin.emc.domain.service.IService.IDJService;
import com.example.admin.emc.presentation.presenter.IPresenter.DJListContract;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by admin on 8/17/2016.
 */
@Singleton
@Component(modules = DJModule.class)
public interface DJComponent {
    IDJService getService();
    DjDao getDao();
    //DJListContract.UserActionListener getPresenter();
}
