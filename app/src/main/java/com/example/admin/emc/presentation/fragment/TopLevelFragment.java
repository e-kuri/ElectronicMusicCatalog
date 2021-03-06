package com.example.admin.emc.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.emc.data.Firebase.GenreDAOFirebaseImpl;
import com.example.admin.emc.R;
import com.example.admin.emc.domain.EMCApplication;
import com.example.admin.emc.domain.adapter.firebase.FirebaseGenreAdapter;
import com.example.admin.emc.domain.event.ChangeFragmentEvent;
import com.example.admin.emc.domain.service.GenreServiceImpl;
import com.example.admin.emc.presentation.presenter.GenrePresenter;
import com.example.admin.emc.presentation.presenter.IPresenter.GenreContract;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by admin on 8/5/2016.
 */
public class TopLevelFragment extends Fragment implements GenreContract.View {

    private RecyclerView recyclerView;
    private GenreContract.UserActionListener presenter;

    public static final String GENRE_KEY = "GENRE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_level, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = ((RecyclerView) getActivity().findViewById(R.id.GenresView));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        presenter = new GenrePresenter(this);
        presenter.getGenreAdapter(R.layout.genre_layout, null, new FirebaseGenreAdapter.Listener() {
            @Override
            public void onclick(String key) {
                EventBus.getDefault().post(new ChangeFragmentEvent(ChangeFragmentEvent.View.DJ_LIST, key, null));
            }
        });
    }



    public void genresLoaded(RecyclerView.Adapter genreAdapter){
        recyclerView.setAdapter(genreAdapter);
    }

}
