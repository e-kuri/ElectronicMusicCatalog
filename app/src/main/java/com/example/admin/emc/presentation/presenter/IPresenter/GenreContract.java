package com.example.admin.emc.presentation.presenter.IPresenter;


import android.support.v7.widget.RecyclerView;

import com.example.admin.emc.domain.adapter.builder.AdapterListener;

/**
 * Created by admin on 8/12/2016.
 */
public interface GenreContract {

    interface View {
        void genresLoaded(RecyclerView.Adapter adapter);
    }

    interface UserActionListener{
        void getGenreAdapter(int layout, String key, AdapterListener listener);
        void setView(GenreContract.View view);
    }

}
