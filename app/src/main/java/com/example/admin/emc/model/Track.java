package com.example.admin.emc.model;

import java.io.Serializable;

/**
 * Created by admin on 7/25/2016.
 */
public class Track implements Serializable{

    private String name;
    private String url;

    public Track(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
