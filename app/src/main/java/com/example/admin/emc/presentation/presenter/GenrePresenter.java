package com.example.admin.emc.presentation.presenter;

import com.example.admin.emc.R;
import com.example.admin.emc.data.DAO.GenreDao;
import com.example.admin.emc.domain.adapter.FirebaseGenreAdapter;
import com.example.admin.emc.domain.callback.IGenreCallback;
import com.example.admin.emc.domain.event.ChangeFragmentEvent;
import com.example.admin.emc.presentation.fragment.TopLevelFragment;
import com.example.admin.emc.presentation.presenter.IPresenter.GenreContract;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by admin on 8/12/2016.
 */
public class GenrePresenter implements GenreContract.UserActionListener {

    private final GenreContract.View view;
    private final GenreDao genreDao;

    public GenrePresenter(GenreContract.View view, GenreDao genreDao){
        this.view = view;
        this.genreDao = genreDao;
    }


    @Override
    public void getGenreAdapter(String key) {
       // if(key == null){
            genreDao.GetAllGenres(new IGenreCallback.GenreListCallback() {
                @Override
                public void onSuccess(Query query) {
                    FirebaseGenreAdapter genreAdapter = new FirebaseGenreAdapter(R.layout.genre_layout, query, new FirebaseGenreAdapter.Listener() {
                        @Override
                        public void onclick(String key) {
                            EventBus.getDefault().post(new ChangeFragmentEvent(ChangeFragmentEvent.View.DJ_LIST));
                        }
                    });
                    view.genresLoaded(genreAdapter);
                }

                @Override
                public void onError(DatabaseError error) {

                }
            });
       // }
    }
}
