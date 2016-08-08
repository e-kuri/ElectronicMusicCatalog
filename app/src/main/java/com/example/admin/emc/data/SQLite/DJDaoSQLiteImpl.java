package com.example.admin.emc.data.SQLite;

import android.content.Context;

import com.example.admin.emc.data.DAO.DjDao;
import com.example.admin.emc.data.model.DJ;

import java.util.List;

/**
 * Created by admin on 7/24/2016.
 */
public class DJDaoSQLiteImpl implements DjDao {

    private Context context;

    public DJDaoSQLiteImpl(Context context){
        this.context = context;
    }

    @Override
    public void insertDJ(DJ dj) {

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

}
