package com.example.admin.electronicmusiccatalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import static com.example.admin.electronicmusiccatalog.R.string.not_supported;

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
    }
}
