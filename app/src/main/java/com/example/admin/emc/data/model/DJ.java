package com.example.admin.emc.data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 7/7/2016.
 */
public class DJ {

    private String username;
    private String name;
    private Map<String, Object> genres;
    private String nationality;
    private String imageURL;
    private List<Track> tracks;
    private String description;

    public DJ(String name, Map<String, Object> genres, String nationality, String imageURL){
        this.name = name;
        this.genres = genres;
        this.nationality = nationality;
        this.imageURL = imageURL;
        tracks = new ArrayList<>();
    }

    public DJ(String username, String name, Map<String, Object> genres, String nationality, String imageURL, String description) {
        this.username = username;
        this.name = name;
        this.genres = genres;
        this.nationality = nationality;
        this.imageURL = imageURL;
        this.description = description;
    }

    public DJ(String name, Map<String, Object> genres, String nationality, String imageURL, String description) {
        this.imageURL = imageURL;
        this.nationality = nationality;
        this.genres = genres;
        this.name = name;
        this.description = description;
    }

    public DJ(){}

    public String getName() {
        return name;
    }

    public Map<String, Object> getGenres() {
        return genres;
    }

    public String getNationality() {
        return nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
