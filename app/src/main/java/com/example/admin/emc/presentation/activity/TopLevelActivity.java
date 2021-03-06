package com.example.admin.emc.presentation.activity;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.admin.emc.R;
import com.example.admin.emc.data.Firebase.FirebaseHelper;
import com.example.admin.emc.domain.event.ChangeFragmentEvent;
import com.example.admin.emc.presentation.fragment.DJDetailFragment;
import com.example.admin.emc.presentation.fragment.DJFragment;
import com.example.admin.emc.presentation.fragment.DJListFragment;
import com.example.admin.emc.presentation.fragment.TopLevelFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class TopLevelActivity extends AppCompatActivity implements DJListFragment.DjListListener {

    private String[] titles;
    private ListView drawerList;
    private FrameLayout container;
    Fragment fragment;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    //private android.support.v4.app.Fragment topFragment;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //Sync the toggle state after onRestoreInstanceState has occured.
        //Syncing means that the icon will be different when it is opened and when it is closed, and
        //syncing will place the correct one.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        drawerLayout = ((DrawerLayout) findViewById(R.id.drawer_layout));

        FirebaseHelper.initializeDB();
        goToMain(true);

        titles = getResources().getStringArray(R.array.titles);
        drawerList = ((ListView) findViewById(R.id.drawer));
        drawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, titles));
        drawerList.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;
                    case 1:
                        goToMain(false);
                        break;
                    default:
                        break;
                }
            drawerLayout.closeDrawer(drawerList);
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

/*
        Point displaySize = new Point();
        this.getWindowManager().getDefaultDisplay().getRealSize(displaySize);
        Rect windowSize = new Rect();
        this.getWindow().getDecorView().getWindowVisibleDisplayFrame(windowSize);
*/
    //    int width = displaySize.x - Math.abs(windowSize.width());
    //    int height = displaySize.y - Math.abs(windowSize.height());


    }

    @Override
    protected void onStart() {
        try {
            super.onStart();
            EventBus.getDefault().register(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void  onEvent(ChangeFragmentEvent event){
        switch (event.getView()){
            case DJ_LIST:
                showDJList(event.getGenre());
                break;
            case DJ_INFO:
                break;
            case MAIN:
                break;
        }
    }

    public void goToMain(boolean firstLoad){
        fragment = new TopLevelFragment();
        //fragment.setFragmentPresenter(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame, fragment, null);
        if(!firstLoad)
            transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showDJList(String genre){
        fragment = new DJFragment();
        ((DJFragment)(fragment)).setGenre(genre);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame, fragment, null);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showDJInfo(String key){
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

    @Override
    public void itemClicked(String key) {
        showDJInfo(key);
    }
}
