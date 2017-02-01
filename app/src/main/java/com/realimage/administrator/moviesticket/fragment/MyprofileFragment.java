package com.realimage.administrator.moviesticket.fragment;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.realimage.administrator.moviesticket.CircleButton;
import com.realimage.administrator.moviesticket.MyView;
import com.realimage.administrator.moviesticket.R;
import com.realimage.administrator.moviesticket.activity.ProfileActivity;
import com.realimage.administrator.moviesticket.activity.WalletActivity;

public class MyprofileFragment extends Fragment {
    private final float LARGE_TEXT_SIZE = 60;
    private final float MEDIUM_TEXT_SIZE = 40;
    private final float SMALL_TEXT_SIZE = 25;
    public int counter;
    // private Justickets myView;
    private CircleButton myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View drawer = inflater.inflate(R.layout.profile_fragment, container, false);
        /*login = (TextView) drawer.findViewById(R.id.profileButton);
        login.setOnClickListener(this);*/
        //    myView_circle = (MyView) drawer.findViewById(R.id.myview);
        myView= (CircleButton) drawer.findViewById(R.id.customView);
        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent profile = new Intent(getActivity(), ProfileActivity.class);
                getActivity().startActivity(profile);

            }
        });
        return drawer;
    }
}