package com.example.admin.emc.db.Firebase;

import com.example.admin.emc.db.DAO.DjDao;
import com.example.admin.emc.db.DAO.GenreDao;
import com.example.admin.emc.model.DJ;
import com.example.admin.emc.model.Genre;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 7/25/2016.
 */
public class FirebaseHelper {

    private static DjDao djDao = DJDaoFirebaseImpl.getInstance();
    private static GenreDao genreDao = GenreDAOFirebaseImpl.getInstance();

    public static void initializeDB(){
        Genre genre = new Genre();
        for(Genre.GenreName genreName : Genre.GenreName.values()){
            genre.setGenre(genreName.toString());
            switch (genreName){
                case TECHNO:
                    genre.setImageUrl("https://i.ytimg.com/vi/-TlQIFKot_0/hqdefault.jpg");
                    break;
                case HOUSE:
                    genre.setImageUrl("http://orig12.deviantart.net/7de4/f/2010/011/e/9/house_music_by_labelrx.png");
                    break;
                case DUBSTEP:
                    genre.setImageUrl("https://images4.alphacoders.com/244/244286.jpg");
                    break;
                case TRANCE:
                    genre.setImageUrl("http://factmag-images.s3.amazonaws.com/wp-content/uploads/2015/12/trance3-12.11.2015.png");
                    break;
            }
            genreDao.insertGenre(genre);
        }


        List<String> genreNames = new ArrayList<>();
        genreNames.add(Genre.GenreName.TECHNO.toString());
        DJ dj = new DJ("dubfire", "Dubfire", genreNames, "Germany", "https://i.ytimg.com/vi/gZrXGG0bINg/maxresdefault.jpg" , "God");
        djDao.insertDJ(dj);
    }

}
