package com.example.admin.emc.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.emc.R;
import com.example.admin.emc.data.model.DJ;
import com.example.admin.emc.presentation.presenter.DetailPresenter;
import com.example.admin.emc.presentation.presenter.IPresenter.DetailContract;


public class DJDetailFragment extends Fragment implements DetailContract.View {

    private String key;
    private TextView name, description;
    private ImageView image;
    private static final String SAVED_KEY = "KEY";
    private DetailContract.UserActionListener presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState != null){
            key = savedInstanceState.getString(SAVED_KEY);
        }
        return inflater.inflate(R.layout.fragment_dj_detail, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(SAVED_KEY, key);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter = new DetailPresenter(this);
        View view = getView();
        if(view != null){

            name = ((TextView) view.findViewById(R.id.name));
            description = ((TextView) view.findViewById(R.id.description));
            image = ((ImageView) view.findViewById(R.id.image));
            presenter.getDjByUsername(key);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter = null;
    }

    public void setData(DJ dj){
        this.name.setText(dj.getName());
        this.description.setText(dj.getDescription());
        Glide.with(getContext()).load(dj.getImageURL()).override(600,400).into(image);
    }

    public void setKey(String key) {
        this.key = key;
    }

}
