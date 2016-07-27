package com.example.admin.emc.db.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.admin.emc.db.DAO.DjDao;
import com.example.admin.emc.model.DJ;

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
    public void deleteDJ(int id) {

    }

    @Override
    public DJ getDJById(int id) {
        return null;
    }

    @Override
    public Cursor getAllDJsForCursor(){
        return null;
    }

}
