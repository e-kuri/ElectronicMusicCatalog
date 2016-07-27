package com.example.admin.emc.db.DAO;

import android.database.Cursor;

import com.example.admin.emc.model.DJ;

/**
 * Created by admin on 7/24/2016.
 */
public interface DjDao {

    public static final String TABLE_NAME = "DJ";

    public enum DJColumns{
        _id, NAME, SUBGENRE, NATIONALITY, IMAGE_URL
    }

    void insertDJ(DJ dj);
    void deleteDJ(int id);
    DJ getDJById(int id);
    Cursor getAllDJsForCursor();
}
