package com.example.admin.electronicmusiccatalog;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 7/16/2016.
 */
public class DJDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "DJ_database";
    private static final int DB_VERSION = 1;

    public DJDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder query = new StringBuilder(100);
        query.append("CREATE TABLE DJ(")
                .append("_id INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append("name TEXT, ")
                .append("genre TEXT, ")
                .append("nationality TEXT, ")
                .append("imageURL TEXT);");
        sqLiteDatabase.execSQL(query.toString()
        );

        insertDJ(sqLiteDatabase, "Dubfire", "Techno", "Germany", "https://i.ytimg.com/vi/gZrXGG0bINg/maxresdefault.jpg");
        insertDJ(sqLiteDatabase, "Oliver Huntemann", "Techno", "Germany", "http://www.divisionagency.com.au/wp-content/uploads/2014/07/OliverHuntemann-Division-1.jpg");
        insertDJ(sqLiteDatabase, "Joseph Capriati", "Techno", "Italy", "http://mixing.dj/wp-content/uploads/2016/04/joseph-capriati.jpg");
        insertDJ(sqLiteDatabase, "Boris Brejcha", "Techno", "Germany", "http://cs622123.vk.me/v622123370/854a/NFgiCHux8n4.jpg");
        insertDJ(sqLiteDatabase, "Pan Pot", "Techno", "Germany", "https://i1.sndcdn.com/avatars-000159094187-q9e982-t500x500.jpg");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void insertDJ(SQLiteDatabase db, String name, String genre, String nationality, String imageURL){
        ContentValues values = new ContentValues();
        values.put("genre", genre);
        values.put("name", name);
        values.put("nationality", nationality);
        values.put("imageURL", imageURL);
        db.insert("DJ", null, values);
    }

    public static String getDbName() {
        return DB_NAME;
    }

    public static int getDbVersion() {
        return DB_VERSION;
    }
}
