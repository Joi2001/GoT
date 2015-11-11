package com.example.android.gotcharacters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static Uri backgroundUrl =
            Uri.parse("http://www.gstatic.com/tv/thumb/tvbanners/8553063/p8553063_b_v7_am.jpg");

    private static SimpleDraweeView mBackgroundView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mBackgroundView =
                (SimpleDraweeView) rootView.findViewById(R.id.app_background);
        mBackgroundView.setImageURI(backgroundUrl);

        final TextView welcomeView = (TextView) rootView.findViewById(R.id.hello_world);
        final EditText inputName = (EditText) rootView.findViewById(R.id.editText);
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        welcomeView.setVisibility(View.GONE);

        final ImageView imageButtonView =
                (ImageView) rootView.findViewById(R.id.image_button);

        imageButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!inputName.getText().toString().equals("")) {
                    String userName = inputName.getText().toString();
                    SharedPreferences sharedPreferences =
                            getActivity().getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(getString(R.string.user_name), userName);
                    editor.apply();
                    mBackgroundView.setVisibility(View.VISIBLE);
                    welcomeView.setText(userName + getString(R.string.hello_world));
                    welcomeView.setVisibility(View.VISIBLE);
                    inputName.setVisibility(View.GONE);
                }
            }
        });

        welcomeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MenuActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
