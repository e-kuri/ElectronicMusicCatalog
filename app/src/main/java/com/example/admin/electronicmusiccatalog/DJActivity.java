package com.example.admin.electronicmusiccatalog;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DJActivity extends AppCompatActivity {

    private List<DJ> djs;
    private RecyclerView recyclerView;
    private DJAdapter djAdapter;
    private SQLiteDatabase db = null;
    private Cursor cursor = null;
    private SQLiteOpenHelper djDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj);

        recyclerView = ((RecyclerView) findViewById(R.id.recycler_view));
        //List<DJ> djList = new ArrayList<>();

        djDatabaseHelper = new DJDatabaseHelper(getApplicationContext());
        new DBAccessAsyncTask().execute();
        recyclerView.setLayoutManager(new LinearLayoutManager(DJActivity.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        /*
        try{
            //new DBAccessAsyncTask().execute();
            //db = djDatabaseHelper.getReadableDatabase();
            //String query = "SELECT * FROM DJ WHERE genre = ?";
            //cursor = db.rawQuery(query, new String[]{"Techno"});
            //cursor = db.query("DJ", null, "genre = ?", new String[] {"Techno"}, null, null, null);

            if(cursor.moveToFirst()){
                int nameIndex = cursor.getColumnIndex("name");
                int nationalityIndex = cursor.getColumnIndex("nationality");
                int genreIndex = cursor.getColumnIndex("genre");
                int imageIndex = cursor.getColumnIndex("imageURL");
                djList.add(new DJ(cursor.getString(nameIndex),
                        cursor.getString(genreIndex),
                        cursor.getString(nationalityIndex),
                        cursor.getString(imageIndex)));
                while (cursor.moveToNext()){
                    djList.add(new DJ(cursor.getString(nameIndex),
                            cursor.getString(genreIndex),
                            cursor.getString(nationalityIndex),
                            cursor.getString(imageIndex)));
                }
            }

            djAdapter = new DJAdapter(this, cursor);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(djAdapter);
        }catch (SQLiteException e){
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        /*finally {

            if(cursor != null){
                cursor.close();
            }
            if(db != null){
                db.close();
            }

        }*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(cursor != null){
            cursor.close();
        }
        if(db != null){
            db.close();
        }
    }

    private class DBAccessAsyncTask extends AsyncTask<Void, Void, Void > {

        @Override
        protected Void doInBackground(Void... vParam) {
            try{
                db = djDatabaseHelper.getReadableDatabase();
                cursor = db.query("DJ", null, "genre = ?", new String[] {"Techno"}, null, null, null);

            }catch (SQLiteException e){
                Toast.makeText(DJActivity.this, "Database unavailable", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void vParam) {
            DJAdapter djAdapter = new DJAdapter(DJActivity.this, cursor);
            recyclerView.setAdapter(djAdapter);
        }
    }
}
