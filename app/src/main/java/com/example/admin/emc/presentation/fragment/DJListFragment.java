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

import com.example.admin.emc.domain.Adapter.FirebaseDjListAdapter;
import com.example.admin.emc.R;
import com.example.admin.emc.data.DAO.DjDao;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * A simple {@link Fragment} subclass.
 */
public class DJListFragment extends Fragment {

    private RecyclerView recyclerView;
    private DjListListener listListener;
    private FirebaseDjListAdapter firebaseAdapter;

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
        View view = getView();
        if (view != null) {
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(DjDao.TABLE_NAME);
            Query lastFifty = ref.limitToLast(50);
            firebaseAdapter = new FirebaseDjListAdapter(R.layout.dj_list_layout, lastFifty, new FirebaseDjListAdapter.Listener() {
                @Override
                public void onclick(String key) {
                    if(listListener != null){
                        listListener.itemClicked(key);
                    }
                }
            });
            recyclerView.setAdapter(firebaseAdapter);
            recyclerView.setAdapter(firebaseAdapter);
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
        firebaseAdapter = null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listListener = (DjListListener) context;
    }
/*
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.listListener = null;
        firebaseAdapter = null;
        recyclerView.setAdapter(null);
        recyclerView = null;
    }
    */
}
