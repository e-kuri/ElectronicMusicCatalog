package com.example.admin.emc.db.DAO;

/**
 * Created by admin on 7/24/2016.
 */
public interface SubGenreDao {
    String TABLE_NAME = "SUBGENRE";

    enum Columns{
        _id, SUBGENRE, ID_GENRE
    }
}
