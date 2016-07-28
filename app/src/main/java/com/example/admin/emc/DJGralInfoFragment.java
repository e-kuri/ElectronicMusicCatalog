package com.example.admin.emc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.emc.Adapter.FirebaseDJAdapter;
import com.example.admin.emc.db.DAO.DjDao;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DJGralInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DJGralInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DJGralInfoFragment extends Fragment {

    private String genre;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dj_gral_info, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view != null){
            recyclerView = ((RecyclerView) view.findViewById(R.id.recycler_view));

            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(DjDao.TABLE_NAME);
            Query lastFifty = ref.limitToLast(50);
            FirebaseDJAdapter firebaseAdapter = new FirebaseDJAdapter(R.layout.dj_layout,  lastFifty);
            recyclerView.setAdapter(firebaseAdapter);
            Log.d("DJGralInfoFragment", "onStart: " + genre);
        }
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    /*
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DJGralInfoFragment() {
        // Required empty public constructor
    }
*/
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DJGralInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    /*
    public static DJGralInfoFragment newInstance(String param1, String param2) {
        DJGralInfoFragment fragment = new DJGralInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

/*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
*/
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    */
}
