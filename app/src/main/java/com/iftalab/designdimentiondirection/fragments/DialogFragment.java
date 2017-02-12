package com.iftalab.designdimentiondirection.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iftalab.designdimentiondirection.R;

/**
 * @author Ifta
 */

public class DialogFragment extends Fragment {
    public DialogFragment() {
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fake,container,false);
        TextView tvFake = (TextView) view.findViewById(R.id.tvFake);
        tvFake.setText("DialogFragment");
        return view;
    }
}
