package com.example.admin.emc.domain.event;

/**
 * Created by admin on 8/9/2016.
 */
public class ChangeFragmentEvent {
    public enum View{
        MAIN, DJ_LIST, DJ_INFO
    }

    private View view;

    public ChangeFragmentEvent(View view){
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
