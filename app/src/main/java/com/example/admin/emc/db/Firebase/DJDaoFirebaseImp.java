package com.example.admin.emc.db.Firebase;

import android.database.Cursor;

import com.example.admin.emc.db.DAO.DjDao;
import com.example.admin.emc.model.DJ;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by admin on 7/25/2016.
 */
public class DJDaoFirebaseImp implements DjDao{

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference ref = db.getReference(TABLE_NAME);

    @Override
    public void insertDJ(DJ dj) {
        ref.setValue(dj);
    }

    @Override
    public void deleteDJ(int id) {
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
    }

    @Override
    public DJ getDJById(int id) {
        return null;
    }

    @Override
    public Cursor getAllDJsForCursor() {
        return null;
    }
}
