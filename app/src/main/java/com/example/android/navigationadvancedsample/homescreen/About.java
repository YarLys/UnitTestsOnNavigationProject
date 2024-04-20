package com.example.android.navigationadvancedsample.homescreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.example.android.navigationadvancedsample.R;

/**
 * Shows "About"
 */
public final class About extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        TextView viewById = (TextView) view.findViewById(R.id.about_tv);
        Intent intent = getActivity().getIntent();
        if(intent.hasExtra("EXTRA")) {
            Bundle inputData = intent.getExtras();
            String input = inputData.getString("EXTRA");
            viewById.setText(input);
        }
        return view;
    }
}
