package com.example.admin.emc.domain.service;

import com.example.admin.emc.data.DAO.DjDao;
import com.example.admin.emc.data.model.DJ;
import com.example.admin.emc.domain.adapter.builder.AdapterBuilder;
import com.example.admin.emc.domain.adapter.builder.AdapterListener;
import com.example.admin.emc.domain.adapter.builder.Exception.AdapterBuilderException;
import com.example.admin.emc.domain.adapter.builder.properties.AdapterBuilderProperties;
import com.example.admin.emc.domain.callback.IDJDetailCallback;
import com.example.admin.emc.domain.callback.IDJListCallback;
import com.example.admin.emc.domain.service.IService.IDJService;
import com.google.firebase.database.DatabaseError;

import javax.inject.Inject;

/**
 * Created by admin on 8/17/2016.
 */
public class DJServiceImpl implements IDJService {

    private final DjDao djDao;

    @Inject
    public DJServiceImpl(DjDao djDao){
        this.djDao = djDao;
    }

    @Override
    public void getDJListAdapter(String genre, final int layout, final AdapterListener listener, final IDJListCallback.DJListCallback callback) {
        djDao.getDJsByGenre(genre, new IDJListCallback.DJListDbCallback() {
            @Override
            public void onSuccess(AdapterBuilderProperties properties) {
                try{
                    properties.setModelLayout(layout);
                    properties.setListener(listener);
                    callback.onSuccess(AdapterBuilder.getBuilder(properties).getAdapter(AdapterBuilder.AdapterContent.DJ_LIST));
                }catch (AdapterBuilderException e){
                    onError(e);
                }
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void getDJByUsername(String username, final IDJDetailCallback.DJByUsernamePresenterCallback callback) {
        djDao.getDJByUsername(username, new IDJDetailCallback.DJByUsernameDaoCallback() {
            @Override
            public void onSuccess(DJ dj) {
                callback.onSuccess(dj);
            }

            @Override
            public void onError(DatabaseError error) {
                callback.onError(error);
            }
        });
    }
/*
    @Override
    public DJ getDJByUsername(String username, ) {
        return null;
    }*/
}
