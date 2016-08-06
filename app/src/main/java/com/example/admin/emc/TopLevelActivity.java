package com.example.admin.emc;

import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.example.admin.emc.Adapter.FirebaseGenreAdapter;
import com.example.admin.emc.db.DAO.GenreDao;
import com.example.admin.emc.db.Firebase.FirebaseHelper;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import io.fabric.sdk.android.Fabric;

public class TopLevelActivity extends AppCompatActivity implements IFragmentPresenter, DJListFragment.DjListListener {

    private static String[] titles;
    private static ListView drawerList;
    private FrameLayout container;
    ParentFragment fragment;
    //private android.support.v4.app.Fragment topFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        goToMain();

        titles = getResources().getStringArray(R.array.titles);
        drawerList = ((ListView) findViewById(R.id.drawer));
        drawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, titles));
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;
                    case 1:
                        goToMain();
                        break;
                    default:
                        break;
                }
            }
        });




/*
        Point displaySize = new Point();
        this.getWindowManager().getDefaultDisplay().getRealSize(displaySize);
        Rect windowSize = new Rect();
        this.getWindow().getDecorView().getWindowVisibleDisplayFrame(windowSize);
*/
    //    int width = displaySize.x - Math.abs(windowSize.width());
    //    int height = displaySize.y - Math.abs(windowSize.height());


    }

    public void goToMain(){
        fragment = new TopLevelFragment();
        fragment.setFragmentPresenter(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame, fragment, null);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showDJList(){
        fragment = new DJFragment();
        fragment.setFragmentPresenter(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame, fragment, null);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showDJInfo(String key){

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
            DJDetailFragment detailFragment = new DJDetailFragment();
            detailFragment.setKey(key);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_frame, detailFragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(null);
            transaction.commit();

        }
    }
}
