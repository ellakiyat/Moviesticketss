package com.realimage.administrator.moviesticket.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.realimage.administrator.moviesticket.R;
import com.realimage.administrator.moviesticket.model.Movies;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends android.support.v4.view.PagerAdapter {
    List<Movies> moviesList;
    Context context;
    LayoutInflater layoutInflater;

/*
    public PagerAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
*/

    public PagerAdapter(List<Movies> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.pager_item, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgpager);
        // Picasso.with(context).load(moviesList.get(position).getTrailer().getThumbnail()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageView);
        try {
            Picasso.with(context).load(moviesList.get(position).getTrailer().getThumbnail()).resize(500, 600).into(imageView);
        } catch (NullPointerException e) {


        }

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return moviesList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
