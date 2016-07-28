package com.example.admin.emc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class DJActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj);

       // DJDetailFragment detailFragment = ((DJDetailFragment) getSupportFragmentManager().findFragmentById(R.id.djdetail_fragment));
       // detailFragment.setGenre(getIntent().getStringExtra(TopLevelActivity.GENRE_KEY));

        /*
        recyclerView = ((RecyclerView) findViewById(R.id.recycler_view));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(DjDao.TABLE_NAME);
        Query lastFifty = ref.limitToLast(50);
        FirebaseDJAdapter firebaseAdapter = new FirebaseDJAdapter(R.layout.dj_detail_layout,  lastFifty);
        recyclerView.setAdapter(firebaseAdapter);
*/
    }
}
