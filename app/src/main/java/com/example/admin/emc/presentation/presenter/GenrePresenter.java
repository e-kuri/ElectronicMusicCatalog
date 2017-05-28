package com.example.admin.emc.presentation.presenter;

import android.support.v7.widget.RecyclerView;

import com.example.admin.emc.R;
import com.example.admin.emc.domain.EMCApplication;
import com.example.admin.emc.domain.adapter.builder.AdapterListener;
import com.example.admin.emc.domain.adapter.builder.Exception.AdapterBuilderException;
import com.example.admin.emc.domain.callback.IGenreCallback;
import com.example.admin.emc.domain.service.IService.IGenreService;
import com.example.admin.emc.domain.service.exception.ServiceException;
import com.example.admin.emc.presentation.presenter.IPresenter.GenreContract;
import com.google.firebase.database.DatabaseError;

import javax.inject.Inject;

/**
 * Created by admin on 8/12/2016.
 */
public class GenrePresenter implements GenreContract.UserActionListener {

    private final GenreContract.View view;
    private IGenreService genreService;


    public GenrePresenter(GenreContract.View view){
        this.view = view;
        this.genreService = EMCApplication.getGenreComponent().getService();
    }

    @Override
    public void getGenreAdapter(int layout, String key, AdapterListener listener) {
        if(key == null){
            try {
                genreService.getAllGenresAdapter(layout, listener, new IGenreCallback.GenreListCallback() {
                    @Override
                    public void onSuccess(RecyclerView.Adapter adapter) {
                        view.genresLoaded(adapter);
                    }

                    @Override
                    public void onError(DatabaseError error) {

                    }
                });
            } catch (ServiceException e) {
                e.printStackTrace();
            } catch (AdapterBuilderException e) {
                e.printStackTrace();
            }

        }
    }

}
