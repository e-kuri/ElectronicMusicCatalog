package com.example.admin.emc.domain.adapter.builder;

import android.support.v7.widget.RecyclerView;

import com.example.admin.emc.domain.adapter.builder.Exception.AdapterBuilderException;
import com.example.admin.emc.domain.adapter.builder.properties.AdapterBuilderProperties;
import com.example.admin.emc.domain.adapter.builder.properties.ArrayAdapterProperties;
import com.example.admin.emc.domain.adapter.builder.properties.FirebaseAdapterBuilderProperties;

/**
 * Created by admin on 8/14/2016.
 */
public abstract class AdapterBuilder {

    public enum AdapterContent{
        GENRE, DJ_LIST
    }

    protected AdapterBuilderProperties properties;

    public abstract RecyclerView.Adapter getAdapter(AdapterContent content);

    public static AdapterBuilder getBuilder(AdapterBuilderProperties properties) throws AdapterBuilderException {
        AdapterBuilder builder = null;
        if(properties instanceof FirebaseAdapterBuilderProperties){
            builder = new FirebaseAdapterBuilder((FirebaseAdapterBuilderProperties) properties);
        }else if(properties instanceof ArrayAdapterProperties){
            builder = new ArrayAdapterBuilder((ArrayAdapterProperties)properties);
        }
        return builder;
    }

    public AdapterBuilderProperties getProperties() {
        return properties;
    }

    public void setProperties(AdapterBuilderProperties properties) {
        this.properties = properties;
    }
}
