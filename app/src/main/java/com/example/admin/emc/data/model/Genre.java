package com.example.admin.emc.data.model;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 7/24/2016.
 */
public class Genre{

    public enum GenreName{
        TECHNO, HOUSE, TRANCE, DUBSTEP
    }

    private String genre;
    private Map<String, Object> djs;
    private String imageUrl;


    public Genre(String genre) {
        this.genre = genre;
    }

    public Genre() {
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Map<String, Object> getDjs() {
        return djs;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
