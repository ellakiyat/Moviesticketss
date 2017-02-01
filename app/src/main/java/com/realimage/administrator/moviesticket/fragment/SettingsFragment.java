package com.realimage.administrator.moviesticket.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.realimage.administrator.moviesticket.activity.AboutActivity;
import com.realimage.administrator.moviesticket.R;
import com.realimage.administrator.moviesticket.activity.ContactActivity;
import com.realimage.administrator.moviesticket.activity.StarActivity;
public class SettingsFragment extends Fragment {
    // LinearLayout layout;
    ImageView img_share, img_star, img_feedback, img_call, img_info;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);

        //layout = (LinearLayout) view.findViewById(R.id.lnlayout);

        img_share = (ImageView) view.findViewById(R.id.shareinfoImageview);
        img_star = (ImageView) view.findViewById(R.id.starinfoImgview);
        img_feedback = (ImageView) view.findViewById(R.id.fdbackinfoImgview);
        img_call = (ImageView) view.findViewById(R.id.callInfoImgview);
        img_info = (ImageView) view.findViewById(R.id.abtinfoImgview);


        img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getActivity().getApplicationContext(),"share item is clicked",Toast.LENGTH_SHORT).show();
                //Implicity intent
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "http://play.google.com/store/apps/details?id=in.justickets.android";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Here is an amazing new app that you must try: ");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        img_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent star = new Intent(getActivity(), StarActivity.class);
                getActivity().startActivity(star);

            }
        });

        img_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity().getApplicationContext(), "feedback item is clicked", Toast.LENGTH_SHORT).show();

            }
        });

        img_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), ContactActivity.class);
                getActivity().startActivity(i);


            }
        });

        img_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent info = new Intent(getActivity(), AboutActivity.class);
                getActivity().startActivity(info);


            }
        });

        return view;
    }
}