package com.example.edgarpetrosian.ithome.Fragment;


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
public class AddPostActivity extends Fragment {


    public AddPostActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_post, container, false);
    }
    public void onResume() {
        super.onResume();

        // Set title bar
        ((ProfileActivity) getActivity())
                .setActionBarTitle("Add Posts");
    }

}
