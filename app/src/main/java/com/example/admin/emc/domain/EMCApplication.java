package com.example.admin.emc.domain;

import android.app.Application;

import com.example.admin.emc.domain.di.component.DaggerGenreComponent;
import com.example.admin.emc.domain.di.component.GenreComponent;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by admin on 8/5/2016.
 */
public class EMCApplication extends Application {

    private RefWatcher refWatcher;
    private GenreComponent genreComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
        genreComponent = DaggerGenreComponent.create();
        /*
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(SYSTEM_DB, SystemDB.FIREBASE.getId());
        editor.commit();
        */
    }

    public GenreComponent getGenreComponent(){
        return genreComponent;
    }
/*
    public static GenreDaoComponent getComponent(Context context){
        return ((EMCApplication)(context.getApplicationContext())).genreComponent;
    }
    */
}
