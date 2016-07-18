package com.example.admin.electronicmusiccatalog;

/**
 * Created by admin on 7/7/2016.
 */
public class DJ {

    private String name;
    private String genre;
    private String nationality;
    private String imageURL;

    public DJ(String name, String genre, String nationality, String imageURL){
        this.name = name;
        this.genre = genre;
        this.nationality = nationality;
        this.imageURL = imageURL;
    }
/*
    public static final DJ[] technoDJs = {
        new DJ("Dubfire", "Techno", "Germany", "https://i.ytimg.com/vi/gZrXGG0bINg/maxresdefault.jpg"),
        new DJ("Oliver Huntemann", "Techno", "Germany", "http://www.divisionagency.com.au/wp-content/uploads/2014/07/OliverHuntemann-Division-1.jpg"),
            new DJ("Joseph Capriati", "Techno", "Italy", "http://mixing.dj/wp-content/uploads/2016/04/joseph-capriati.jpg"),
            new DJ("Boris Brejcha", "Techno", "Germany", "http://cs622123.vk.me/v622123370/854a/NFgiCHux8n4.jpg"),
            new DJ("Pan Pot", "Techno", "Germany", "https://i1.sndcdn.com/avatars-000159094187-q9e982-t500x500.jpg")
    };
*/
    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getNationality() {
        return nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String genre) {
        this.genre = genre;
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
}
