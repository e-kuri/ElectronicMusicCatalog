package com.example.admin.emc.data.DAO;

import com.example.admin.emc.domain.callback.IDJDetailCallback;
import com.example.admin.emc.domain.callback.IDJListCallback;
import com.example.admin.emc.data.model.DJ;

import java.util.List;

/**
 * Created by admin on 7/24/2016.
 */
public interface DjDao {

    public static final String TABLE_NAME = "DJ";

    void insertDJ(DJ dj);
    void deleteDJ(String username);
    void getDJByUsername(String username, IDJDetailCallback.DJByUsernameDaoCallback callback);
    List<DJ> getAllDJs();
    void getDJsByGenre(String genre, IDJListCallback.DJListDbCallback callback);
}
