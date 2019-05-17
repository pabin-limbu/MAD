package com.example.pabinnavigation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn_screen1 = view.findViewById(R.id.btn_screen_1);
        Button btn_screen2 = view.findViewById(R.id.btn_screen_2);

        View.OnClickListener screenListener1 = Navigation.createNavigateOnClickListener(R.id.go_to_screen1);
        View.OnClickListener screenListener2 = Navigation.createNavigateOnClickListener(R.id.go_to_screen2);

        btn_screen1.setOnClickListener(screenListener1);
        btn_screen2.setOnClickListener(screenListener2);
    }
}
