package com.example.admin.emc.db.Firebase;

import com.example.admin.emc.db.DAO.DjDao;
import com.example.admin.emc.model.DJ;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by admin on 7/26/2016.
 */
public class DJDaoFirebaseImpl implements DjDao {

    private static DJDaoFirebaseImpl instance;
    private DatabaseReference db = FirebaseDatabase.getInstance().getReference().child(DjDao.TABLE_NAME);

    private DJDaoFirebaseImpl(){

    }

    @Override
    public void insertDJ(DJ dj) throws DatabaseException {
        if(dj.getUsername() == null || dj.getUsername().length() == 0)
            throw new DatabaseException("username is a mandatory field");

        String username = dj.getUsername();
        dj.setUsername(null);
        db.child(username).setValue(dj);
    }

    @Override
    public void deleteDJ(String username) {

    }

    @Override
    public DJ getDJByUsername(String username) {
        return null;
    }

    @Override
    public List<DJ> getAllDJs() {
        return null;
    }

    public static DJDaoFirebaseImpl getInstance(){
        if(instance == null)
            instance = new DJDaoFirebaseImpl();

        return instance;
    }

}
