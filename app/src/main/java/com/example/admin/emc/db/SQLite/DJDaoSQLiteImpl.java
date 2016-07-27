package com.example.admin.emc.db.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.admin.emc.db.DAO.DjDao;
import com.example.admin.emc.model.DJ;

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
