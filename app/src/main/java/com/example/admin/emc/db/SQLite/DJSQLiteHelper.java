package com.example.admin.emc.db.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.emc.R;
import com.example.admin.emc.db.DAO.DjDao;
import com.example.admin.emc.db.DAO.DjSubgenreDao;
import com.example.admin.emc.db.DAO.GenreDao;
import com.example.admin.emc.db.DAO.SubGenreDao;
import com.example.admin.emc.model.Genre;
import com.example.admin.emc.model.SubGenre;

/**
 * Created by admin on 7/16/2016.
 */
public class DJSQLiteHelper extends SQLiteOpenHelper {
/*
    public static final String DB_NAME = "DJ_database";
    public static final int DB_VERSION = 1;
    public static final String DJ_TABLE_NAME = "DJ";
*/

    public DJSQLiteHelper(Context context){
        super(context, context.getString(R.string.DB_NAME), null, context.getResources().getInteger(R.integer.DB_VERSION));
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

 /*       StringBuilder query = new StringBuilder(100);
        query.append("CREATE TABLE ").append(GenreDao.TABLE_NAME).append("(")
                .append(GenreDao.Columns._id).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(GenreDao.Columns.GENRE).append(" TEXT);");
        sqLiteDatabase.execSQL(query.toString());

        query.setLength(0);
        query.append("CREATE TABLE ").append(SubGenreDao.TABLE_NAME).append("( ")
                .append(SubGenreDao.Columns._id).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(SubGenreDao.Columns.SUBGENRE).append(" TEXT, ")
                .append(SubGenreDao.Columns.ID_GENRE).append(" INTEGER, ")
                .append("FOREIGN KEY (").append(SubGenreDao.Columns.ID_GENRE)
                .append(") REFERENCES ").append(GenreDao.TABLE_NAME).append("(").append("_id").append(");");
        sqLiteDatabase.execSQL(query.toString());*/
/*
        query.setLength(0);
        query.append("CREATE TABLE ").append(DjDao.TABLE_NAME).append("(")
                .append(DjDao.DJColumns._id).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(DjDao.DJColumns.NAME).append(" TEXT, ")
                .append(DjDao.DJColumns.NATIONALITY).append(" TEXT, ")
                .append(DjDao.DJColumns.IMAGE_URL).append(" TEXT);");
        sqLiteDatabase.execSQL(query.toString()
        );

        query.setLength(0);
        query.append("CREATE TABLE ").append(DjSubgenreDao.TABLE_NAME).append("(")
                .append(DjSubgenreDao.Columns.DJ_ID).append(" INTEGER, ")
                .append(DjSubgenreDao.Columns.SUBGENRE_ID).append(" INTEGER, ")
                .append("PRIMARY KEY (").append(DjSubgenreDao.Columns.DJ_ID).append(", ")
                .append(DjSubgenreDao.Columns.SUBGENRE_ID).append("), ")
                .append("FOREIGN KEY(").append(DjSubgenreDao.Columns.DJ_ID).append(") REFERENCES ")
                .append(DjDao.TABLE_NAME).append("(").append(DjDao.DJColumns._id).append("), ")
                .append("FOREIGN KEY(").append(DjSubgenreDao.Columns.SUBGENRE_ID).append(") REFERENCES ")
                .append(SubGenreDao.TABLE_NAME).append("(").append(SubGenreDao.Columns._id).append(");");

        insertDJ(sqLiteDatabase, "Dubfire", "Techno", "Germany", "https://i.ytimg.com/vi/gZrXGG0bINg/maxresdefault.jpg");
        insertDJ(sqLiteDatabase, "Oliver Huntemann", "Techno", "Germany", "http://www.divisionagency.com.au/wp-content/uploads/2014/07/OliverHuntemann-Division-1.jpg");
        insertDJ(sqLiteDatabase, "Joseph Capriati", "Techno", "Italy", "http://mixing.dj/wp-content/uploads/2016/04/joseph-capriati.jpg");
        insertDJ(sqLiteDatabase, "Boris Brejcha", "Techno", "Germany", "http://cs622123.vk.me/v622123370/854a/NFgiCHux8n4.jpg");
        insertDJ(sqLiteDatabase, "Pan Pot", "Techno", "Germany", "https://i1.sndcdn.com/avatars-000159094187-q9e982-t500x500.jpg");

    }

    private void insertDJ(SQLiteDatabase db, String name, String genre, String nationality, String imageURL){
        try{
            ContentValues values = new ContentValues();
            values.put(DjDao.DJColumns.SUBGENRE.toString(), genre);
            values.put(DjDao.DJColumns.NAME.toString(), name);
            values.put(DjDao.DJColumns.NATIONALITY.toString(), nationality);
            values.put(DjDao.DJColumns.IMAGE_URL.toString(), imageURL);
            db.insert(DjDao.TABLE_NAME, null, values);
        }catch (Exception e){
            e.printStackTrace();
        }
    */}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
