package com.example.admin.emc.domain.adapter.builder.properties;

import com.example.admin.emc.domain.adapter.builder.properties.AdapterBuilderProperties;

import java.util.List;

/**
 * Created by admin on 8/17/2016.
 */
public class ArrayAdapterProperties extends AdapterBuilderProperties {
    private List content;

    public ArrayAdapterProperties(){}

    public ArrayAdapterProperties(List content){
        this.content = content;
    }

    public List getContent() {
        return content;
    }

    public void setContent(List content) {
        this.content = content;
    }
}