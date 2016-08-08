package com.example.admin.emc.presentation.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by admin on 8/5/2016.
 */
public abstract class ParentFragment extends Fragment {
    public abstract void setFragmentPresenter(IFragmentPresenter fragmentPresenter);
}
