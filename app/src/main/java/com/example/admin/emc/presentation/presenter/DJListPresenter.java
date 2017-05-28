package com.example.admin.emc.presentation.presenter;

import android.support.v7.widget.RecyclerView;

import com.example.admin.emc.domain.EMCApplication;
import com.example.admin.emc.domain.adapter.builder.AdapterListener;
import com.example.admin.emc.domain.callback.IDJListCallback;
import com.example.admin.emc.domain.service.IService.IDJService;
import com.example.admin.emc.presentation.presenter.IPresenter.DJListContract;
import com.google.firebase.database.DatabaseError;

import javax.inject.Inject;

/**
 * Created by admin on 8/12/2016.
 */
public class DJListPresenter implements DJListContract.UserActionListener {

    private final DJListContract.View view;
    private IDJService djService;

    @Inject
    public DJListPresenter(DJListContract.View view){
        this.view = view;
        djService = EMCApplication.getDjComponent().getService();
    }


    @Override
    public void getDJAdapterByGenre(int layout, String genre, AdapterListener listener) {
        djService.getDJListAdapter(genre, layout, listener, new IDJListCallback.DJListCallback() {
            @Override
            public void onSuccess(RecyclerView.Adapter adapter) {
                view.afterDJsLoaded(adapter);
            }

            @Override
            public void onError(DatabaseError error) {

            }
        });
        /*
        djDao.getDJsByGenre(key, new IDJListCallback.DJListCallback() {
            @Override
            public void onSuccess(Query query) {
                FirebaseDjListAdapter firebaseAdapter = new FirebaseDjListAdapter(R.layout.dj_list_layout, query, new FirebaseDjListAdapter.Listener() {
                    @Override
                    public void onclick(String key) {
                        view.setListener(key);
                    }
                });
                view.afterDJsLoaded(firebaseAdapter);
            }

            @Override
            public void onError(DatabaseError error) {

            }
        });*/
    }

}
