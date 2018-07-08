package com.example.edgarpetrosian.ithome.Web;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edgarpetrosian.ithome.Activity.ProfileActivity;
import com.example.edgarpetrosian.ithome.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebTrainingsFragment extends Fragment {


    public WebTrainingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_trainings, container, false);
    }
    public void onResume() {
        super.onResume();
        // Set title bar
        ((ProfileActivity) getActivity())
                .setActionBarTitle("WEB");
    }
}
