package com.example.admin.emc.presentation.presenter.IPresenter;


import com.example.admin.emc.domain.adapter.FirebaseGenreAdapter;

/**
 * Created by admin on 8/12/2016.
 */
public interface GenreContract {

    interface View {
        void genresLoaded(FirebaseGenreAdapter genreAdapter);
    }

    interface UserActionListener{
        void getGenreAdapter(String key);
    }

}
