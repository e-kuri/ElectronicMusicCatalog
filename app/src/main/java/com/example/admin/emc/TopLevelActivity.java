package com.example.admin.emc;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.emc.Adapter.FirebaseGenreAdapter;
import com.example.admin.emc.db.DAO.GenreDao;
import com.example.admin.emc.db.Firebase.FirebaseHelper;
import com.example.admin.emc.model.Genre;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;
import java.util.Map;

public class TopLevelActivity extends AppCompatActivity {

    private ListView lv;
    private RecyclerView recyclerView;
    private FirebaseGenreAdapter genreAdapter;

    public static final String GENRE_KEY = "GENRE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
/*
        Point displaySize = new Point();
        this.getWindowManager().getDefaultDisplay().getRealSize(displaySize);
        Rect windowSize = new Rect();
        this.getWindow().getDecorView().getWindowVisibleDisplayFrame(windowSize);
*/
    //    int width = displaySize.x - Math.abs(windowSize.width());
    //    int height = displaySize.y - Math.abs(windowSize.height());

        recyclerView = ((RecyclerView) findViewById(R.id.GenresView));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(GenreDao.TABLE_NAME);
        Query lastFifty = ref.limitToLast(50);
        genreAdapter = new FirebaseGenreAdapter(R.layout.genre_layout, lastFifty, new FirebaseGenreAdapter.Listener() {
            @Override
            public void onclick(String key) {
                Intent i = new Intent(TopLevelActivity.this, DJActivity.class);
                i.putExtra(GENRE_KEY, key);
                startActivity(i);
            }
        });
        recyclerView.setAdapter(genreAdapter);
/*
        AdapterView.OnItemClickListener listViewClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(TopLevelActivity.this, DJActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(TopLevelActivity.this, R.string.not_supported, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        lv.setOnItemClickListener(listViewClickListener);
*/
        FirebaseHelper.initializeDB();
    }
}
