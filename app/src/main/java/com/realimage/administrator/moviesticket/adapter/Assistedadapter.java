package com.realimage.administrator.moviesticket.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.realimage.administrator.moviesticket.model.Assitedmovies;
import com.realimage.administrator.moviesticket.R;
import com.squareup.picasso.Picasso;
import java.util.List;


public class Assistedadapter extends RecyclerView.Adapter<Assistedadapter.ViewHolder> {


    private List<Assitedmovies> assistedmovies;
    private Context context;

    //Create constructor
    public Assistedadapter(List<Assitedmovies> assistedmovies, Context context) {
        this.assistedmovies = assistedmovies;
        this.context = context;
    }

    @Override
    public Assistedadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assisted_movie, parent, false);
        return new Assistedadapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(Assistedadapter.ViewHolder holder, int position) {

        try {
            Picasso.with(context).load(assistedmovies.get(position).getTrailer().getThumbnail()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.img_assisted);
        } catch (NullPointerException e) {

        }
    }


    @Override
    public int getItemCount() {
        return assistedmovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_assisted;

        public ViewHolder(View view) {
            super(view);
            img_assisted = (ImageView) view.findViewById(R.id.assisted_img);

            img_assisted.setScaleType(ImageView.ScaleType.FIT_XY);
            /*img_android.getLayoutParams().width=230;
            img_android.getLayoutParams().height=230;*/
        }
    }
}
