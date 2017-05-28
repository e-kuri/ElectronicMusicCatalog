package com.example.admin.emc.presentation.presenter;

import android.widget.Toast;

import com.example.admin.emc.data.model.DJ;
import com.example.admin.emc.domain.EMCApplication;
import com.example.admin.emc.domain.callback.IDJDetailCallback;
import com.example.admin.emc.domain.callback.IDJListCallback;
import com.example.admin.emc.domain.service.IService.IDJService;
import com.example.admin.emc.presentation.presenter.IPresenter.DetailContract;
import com.google.firebase.database.DatabaseError;

/**
 * Created by admin on 8/12/2016.
 */
public class DetailPresenter implements DetailContract.UserActionListener{

    private IDJService djService;
    private final DetailContract.View view;

    public DetailPresenter(DetailContract.View view){
        this.view = view;
        this.djService = EMCApplication.getDjComponent().getService();
    }

    public void getDjByUsername(String key){
        djService.getDJByUsername(key, new IDJDetailCallback.DJByUsernamePresenterCallback() {
            @Override
            public void onSuccess(DJ dj) {
                view.setData(dj);
            }

            @Override
            public void onError(DatabaseError error) {
                error.toException().printStackTrace();
            }
        });
    }


}
