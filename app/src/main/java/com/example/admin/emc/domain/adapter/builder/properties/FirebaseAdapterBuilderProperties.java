package com.example.admin.emc.domain.adapter.builder.properties;

import com.example.admin.emc.domain.adapter.builder.AdapterListener;
import com.google.firebase.database.Query;

/**
 * Created by admin on 8/14/2016.
 */
public class FirebaseAdapterBuilderProperties extends AdapterBuilderProperties {

    private Query ref;
    protected int modelLayout;

    public Query getRef() {
        return ref;
    }

    public void setRef(Query ref) {
        this.ref = ref;
    }

    public int getModelLayout() {
        return modelLayout;
    }

    public void setModelLayout(int modelLayout) {
        this.modelLayout = modelLayout;
    }
}
