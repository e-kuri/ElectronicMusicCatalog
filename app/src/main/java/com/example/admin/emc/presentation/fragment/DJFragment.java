package com.example.admin.emc.presentation.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.emc.R;

public class DJFragment extends ParentFragment {

    //private RecyclerView recyclerView;
    private IFragmentPresenter fragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dj, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.djlist_fragment, new DJListFragment());
        transaction.commit();
    }
/*
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.fragmentPresenter = null;
    }
*/
    @Override
    public void setFragmentPresenter(IFragmentPresenter fragmentPresenter) {
        this.fragmentPresenter = fragmentPresenter;
    }
}
