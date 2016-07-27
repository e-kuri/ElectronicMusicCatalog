package com.example.admin.emc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.emc.db.DAO.GenreDao;
import com.example.admin.emc.db.Firebase.FirebaseHelper;
import com.example.admin.emc.model.Genre;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class TopLevelActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        lv = ((ListView) findViewById(R.id.listView));

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

        FirebaseHelper.initializeDB();
    }
}
