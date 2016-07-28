package com.example.admin.emc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.emc.Adapter.FirebaseDJAdapter;
import com.example.admin.emc.Adapter.FirebaseDjListAdapter;
import com.example.admin.emc.R;
import com.example.admin.emc.db.DAO.DjDao;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * A simple {@link Fragment} subclass.
 */
public class DJListFragment extends Fragment {

    private RecyclerView recyclerView;

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
            recyclerView = ((RecyclerView) view.findViewById(R.id.DJListReciclerView));

            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(DjDao.TABLE_NAME);
            Query lastFifty = ref.limitToLast(50);
            FirebaseDjListAdapter firebaseAdapter = new FirebaseDjListAdapter(R.layout.dj_list_layout, lastFifty, new FirebaseDjListAdapter.Listener() {
                @Override
                public void onclick(String key) {

                }
            });
            recyclerView.setAdapter(firebaseAdapter);
            recyclerView.setAdapter(firebaseAdapter);
        }
    }
}
