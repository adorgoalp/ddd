package com.iftalab.designdimentiondirection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Acer PC on 2/12/2017.
 */

public class LauncherIconFragment extends Fragment {
    public LauncherIconFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fake,container,false);
        TextView tvFake = (TextView) view.findViewById(R.id.tvFake);
        tvFake.setText("LauncherIconFragment");
        return view;
    }
}
