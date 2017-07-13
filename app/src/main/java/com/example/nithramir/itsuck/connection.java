package com.example.nithramir.itsuck;

/**
 * Created by Nithramir on 11/07/2017.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import static android.R.attr.onClick;

public class connection extends Fragment implements View.OnClickListener {
    MainActivity act;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        act = (MainActivity)getActivity();
        // Inflate the layout for this fragment
        View view = LinearLayout.inflate(act, R.layout.connect_visu, null);
        view.findViewById(R.id.connect).setOnClickListener(this);

        return view;
    }
    public void onClick(View v) {
        Log.e("test","test");
        NavigationView navigationView = (NavigationView) act.findViewById(R.id.nav_view);
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.inscription).setVisible(false);
        nav_Menu.findItem(R.id.connection).setTitle("Baptiste");
        act.setPseudo("Baptiste");
    }
}
