package com.example.admin.emc.presentation.presenter.IPresenter;

import android.support.v7.widget.RecyclerView;

import com.example.admin.emc.domain.adapter.builder.AdapterListener;

/**
 * Created by admin on 8/12/2016.
 */
public interface DJListContract {

    interface View{
        void afterDJsLoaded(RecyclerView.Adapter adapter);
        void setListener(String string);
    }

    interface UserActionListener{
        void getDJAdapterByGenre(int layout, String key, AdapterListener listener);
    }

}
