package com.example.admin.emc.presentation.fragment;

/**
 * Created by admin on 8/5/2016.
 */
public interface IFragmentPresenter {
    void goToMain(boolean firstLoad);
    void showDJList();
    void showDJInfo(String key);
}
