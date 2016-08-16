package com.example.admin.emc.presentation.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.emc.data.Firebase.DJDaoFirebaseImpl;
import com.example.admin.emc.R;
import com.example.admin.emc.presentation.presenter.DJListPresenter;
import com.example.admin.emc.presentation.presenter.IPresenter.DJListContract;

/**
 * A simple {@link Fragment} subclass.
 */
public class DJListFragment extends Fragment implements DJListContract.View {

    private RecyclerView recyclerView;
    private DjListListener listListener;
    private DJListContract.UserActionListener presenter;

    public static interface DjListListener{
        void itemClicked(String key);
    }

    public DJListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dj_list, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter = new DJListPresenter(this, DJDaoFirebaseImpl.getInstance());
        View view = getView();
        if (view != null) {
            presenter.DJsByGenre(null);
        }
    }


    @Override
    public void afterDJsLoaded(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    public void setListener(String key){
        if(listListener != null){
            listListener.itemClicked(key);
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        if (view != null) {
            recyclerView = ((RecyclerView) view.findViewById(R.id.DJListReciclerView));

            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter = null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listListener = (DjListListener) context;
    }

}
