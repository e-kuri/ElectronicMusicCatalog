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
import com.example.admin.emc.db.DAO.DjDao;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DJDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DJDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DJDetailFragment extends Fragment {

    private String genre;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dj_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view != null){
            recyclerView = ((RecyclerView) view.findViewById(R.id.recycler_view));

            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(DjDao.TABLE_NAME);
            Query lastFifty = ref.limitToLast(50);
            FirebaseDJAdapter firebaseAdapter = new FirebaseDJAdapter(R.layout.dj_detail_layout,  lastFifty);
            recyclerView.setAdapter(firebaseAdapter);
            Log.d("DJDetailFragment", "onStart: " + genre);
        }
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
