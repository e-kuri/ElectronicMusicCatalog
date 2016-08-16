package com.example.admin.emc.domain.adapter.builder.properties;

import com.example.admin.emc.domain.adapter.builder.AdapterListener;

/**
 * Created by admin on 8/14/2016.
 */
public abstract class AdapterBuilderProperties {
    protected int modelLayout;
    private AdapterListener listener;

    public int getModelLayout() {
        return modelLayout;
    }

    public void setModelLayout(int modelLayout) {
        this.modelLayout = modelLayout;
    }

    public AdapterListener getListener() {
        return listener;
    }

    public void setListener(AdapterListener listener) {
        this.listener = listener;
    }
}
