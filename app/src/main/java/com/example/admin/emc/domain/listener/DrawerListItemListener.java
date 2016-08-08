package com.example.admin.emc.domain.listener;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.admin.emc.R;
import com.example.admin.emc.presentation.fragment.TopLevelFragment;

/**
 * Created by admin on 8/8/2016.
 */
public class DrawerListItemListener{
    /*
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

    private void goToMain(boolean firstLoad){
        fragment = new TopLevelFragment();
        fragment.setFragmentPresenter(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame, fragment, null);
        if(!firstLoad)
            transaction.addToBackStack(null);
        transaction.commit();
    }
*/}
