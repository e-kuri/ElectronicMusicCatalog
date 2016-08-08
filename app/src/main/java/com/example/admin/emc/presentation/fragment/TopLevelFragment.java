package com.example.admin.emc.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.emc.domain.Adapter.FirebaseGenreAdapter;
import com.example.admin.emc.R;
import com.example.admin.emc.data.DAO.GenreDao;
import com.example.admin.emc.data.Firebase.FirebaseHelper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * Created by admin on 8/5/2016.
 */
public class TopLevelFragment extends ParentFragment {

    private IFragmentPresenter fragmentPresenter;
    private RecyclerView recyclerView;
    private FirebaseGenreAdapter genreAdapter;

    public static final String GENRE_KEY = "GENRE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top_level, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = ((RecyclerView) getActivity().findViewById(R.id.GenresView));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(GenreDao.TABLE_NAME);
        Query lastFifty = ref.limitToLast(50);
        genreAdapter = new FirebaseGenreAdapter(R.layout.genre_layout, lastFifty, new FirebaseGenreAdapter.Listener() {
            @Override
            public void onclick(String key) {
                /*
                Intent i = new Intent(getActivity(), DJFragment.class);
                i.putExtra(GENRE_KEY, key);
                startActivity(i);
                */
                fragmentPresenter.showDJList();
            }
        });
        recyclerView.setAdapter(genreAdapter);
        FirebaseHelper.initializeDB();
    }
/*
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.fragmentPresenter = null;
        genreAdapter = null;
        recyclerView = null;
    }
*/
    public void setFragmentPresenter(IFragmentPresenter fragmentPresenter){
        this.fragmentPresenter = fragmentPresenter;
    }
}
