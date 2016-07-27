package com.example.admin.emc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 7/7/2016.
 */
public class DJ implements Serializable{

    private String username;
    private String name;
    private List<Genre.GenreName> genres;
    private String nationality;
    private String imageURL;
    private List<Track> tracks;
    private String description;

    public DJ(String name, List<Genre.GenreName> genres, String nationality, String imageURL){
        this.name = name;
        this.genres = genres;
        this.nationality = nationality;
        this.imageURL = imageURL;
        tracks = new ArrayList<>();
    }

    public DJ(String username, String name, List<Genre.GenreName> genres, String nationality, String imageURL, List<Track> tracks) {
        this.username = username;
        this.name = name;
        this.genres = genres;
        this.nationality = nationality;
        this.imageURL = imageURL;
        this.tracks = tracks;
    }

    public DJ(String imageURL, String nationality, List<Genre.GenreName> genres, String name, String description) {
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

    public List<Genre.GenreName> getGenres() {
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
