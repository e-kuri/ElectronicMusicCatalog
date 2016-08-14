package com.example.admin.emc.presentation.presenter.IPresenter;

import com.example.admin.emc.domain.adapter.FirebaseDjListAdapter;

/**
 * Created by admin on 8/12/2016.
 */
public interface DJListContract {

    interface View{
        void afterDJsLoaded(FirebaseDjListAdapter adapter);
        void setListener(String string);
    }

    interface UserActionListener{
        void DJsByGenre(String key);
    }

}
