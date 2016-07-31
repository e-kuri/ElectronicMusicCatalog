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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.emc.db.DAO.DjDao;
import com.example.admin.emc.model.DJ;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;


public class DJDetailFragment extends Fragment {

    private String key;
    private TextView name, description;
    private ImageView image;
    private static final String SAVED_KEY = "KEY";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState != null){
            key = savedInstanceState.getString(SAVED_KEY);
        }
        return inflater.inflate(R.layout.fragment_dj_detail, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(SAVED_KEY, key);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view != null){

            name = ((TextView) view.findViewById(R.id.name));
            description = ((TextView) view.findViewById(R.id.description));
            image = ((ImageView) view.findViewById(R.id.image));
            /*
            recyclerView = ((RecyclerView) view.findViewById(R.id.recycler_view));

            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(DjDao.TABLE_NAME);
            Query lastFifty = ref.limitToLast(50);
            FirebaseDJAdapter firebaseAdapter = new FirebaseDJAdapter(R.layout.dj_detail_layout,  lastFifty);
            recyclerView.setAdapter(firebaseAdapter);
            Log.d("DJDetailFragment", "onStart: " + genre);
            */

            if(key != null){
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(DjDao.TABLE_NAME).child(key);
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        DJ dj = dataSnapshot.getValue(DJ.class);
                        setData(dj);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

        }
    }

    private void setData(DJ dj){
        this.name.setText(dj.getName());
        this.description.setText(dj.getDescription());
        Glide.with(getContext()).load(dj.getImageURL()).override(600,400).into(image);
    }

    public void setKey(String key) {
        this.key = key;
    }

}
