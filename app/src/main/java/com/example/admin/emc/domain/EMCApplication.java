package com.example.admin.emc.domain;

import android.app.Application;

import com.example.admin.emc.domain.di.component.DJComponent;
import com.example.admin.emc.domain.di.component.DaggerDJComponent;
import com.example.admin.emc.domain.di.component.DaggerGenreComponent;
import com.example.admin.emc.domain.di.component.GenreComponent;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by admin on 8/5/2016.
 */
public class EMCApplication extends Application {

    private RefWatcher refWatcher;
    private static GenreComponent genreComponent;
    private static DJComponent djComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);

    }

    public static GenreComponent getGenreComponent(){
        if(genreComponent == null)
            genreComponent = DaggerGenreComponent.create();
        return genreComponent;
    }

    public static DJComponent getDjComponent(){
        if(djComponent == null)
            djComponent = DaggerDJComponent.create();

        return djComponent;
    }

}
