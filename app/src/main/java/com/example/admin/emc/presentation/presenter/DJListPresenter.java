package com.example.admin.emc.presentation.presenter;

import com.example.admin.emc.R;
import com.example.admin.emc.data.DAO.DjDao;
import com.example.admin.emc.domain.adapter.FirebaseDjListAdapter;
import com.example.admin.emc.domain.callback.IDJCallback;
import com.example.admin.emc.presentation.presenter.IPresenter.DJListContract;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;

/**
 * Created by admin on 8/12/2016.
 */
public class DJListPresenter implements DJListContract.UserActionListener {

    private final DJListContract.View view;
    private final DjDao djDao;

    public DJListPresenter(DJListContract.View view, DjDao djDao){
        this.djDao = djDao;
        this.view = view;
    }


    @Override
    public void DJsByGenre(String key) {
        djDao.getDJsByGenre(key, new IDJCallback.DJListCallback() {
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
        });
    }
}
