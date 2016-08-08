package com.example.admin.emc.data.DAO;

import com.example.admin.emc.data.model.DJ;

import java.util.List;

/**
 * Created by admin on 7/24/2016.
 */
public interface DjDao {

    public static final String TABLE_NAME = "DJ";

    void insertDJ(DJ dj);
    void deleteDJ(String username);
    DJ getDJByUsername(String username);
    List<DJ> getAllDJs();
}
