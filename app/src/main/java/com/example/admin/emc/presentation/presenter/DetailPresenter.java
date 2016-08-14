package com.example.admin.emc.presentation.presenter;

import com.example.admin.emc.data.DAO.DjDao;
import com.example.admin.emc.data.model.DJ;
import com.example.admin.emc.domain.callback.IDJCallback;
import com.example.admin.emc.presentation.presenter.IPresenter.DetailContract;
import com.google.firebase.database.DatabaseError;

/**
 * Created by admin on 8/12/2016.
 */
public class DetailPresenter implements DetailContract.UserActionListener{

    private final DjDao djDao;
    private final DetailContract.View view;

    public DetailPresenter(DjDao djDao, DetailContract.View view){
        this.djDao = djDao;
        this.view = view;
    }

    public void getDjByUsername(String key){
        if(key != null){
            djDao.getDJByUsername(key, new IDJCallback.DJDetailCallback() {
                @Override
                public void onSuccess(DJ dj) {
                    view.setData(dj);
                }

                @Override
                public void onError(DatabaseError error) {

                }
            });
        }
    }

}
