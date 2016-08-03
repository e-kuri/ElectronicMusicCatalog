package com.example.admin.emc;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DJActivity extends AppCompatActivity implements DJListFragment.DjListListener{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj);

    }

    @Override
    public void itemClicked(String key) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if(fragmentContainer != null){
            DJDetailFragment detailFragment = new DJDetailFragment();
            detailFragment.setKey(key);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, detailFragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(null);
            transaction.commit();
        }else {
            Intent i = new Intent(this, DjDetailActivity.class);
            i.putExtra(DjDetailActivity.DJ_KEY, key);
            startActivity(i);
        }
    }
}
