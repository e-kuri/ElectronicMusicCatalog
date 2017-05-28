package com.example.admin.emc.domain.event;

/**
 * Created by admin on 8/9/2016.
 */
public class ChangeFragmentEvent {
    public enum View{
        MAIN, DJ_LIST, DJ_INFO
    }

    private View view;
    private String genre;
    private String dj;

    public ChangeFragmentEvent(View view, String genre, String dj){
        this.view = view;
        this.genre = genre;
        this.dj = dj;
    }

    public View getView() {
        return view;
    }

    public String getGenre() {
        return genre;
    }

    public String getDj() {
        return dj;
    }
}
