package com.example.admin.emc.model;

import android.support.annotation.TransitionRes;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 7/24/2016.
 */
public class Genre{

    public enum GenreName{
        TECHNO, HOUSE, TRANCE, DUBSTEP
    }

    private String genre;
    private List<String> djs;
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

    public List<String> getDjs() {
        return djs;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
