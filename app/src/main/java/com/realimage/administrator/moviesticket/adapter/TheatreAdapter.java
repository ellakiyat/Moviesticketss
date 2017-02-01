package com.realimage.administrator.moviesticket.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.realimage.administrator.moviesticket.activity.InfoActivity;
import com.realimage.administrator.moviesticket.model.Movies;
import com.squareup.picasso.Picasso;
import java.util.List;
import com.realimage.administrator.moviesticket.R;

public class TheatreAdapter extends RecyclerView.Adapter<TheatreAdapter.ViewHolder> {

    private List<Movies> moviesList1;
    private Context context;

    //create constructor
    public TheatreAdapter(List<Movies> moviesList1, Context context) {
        this.moviesList1 = moviesList1;
        this.context = context;
    }
//To inflate the xml file
    @Override
    public TheatreAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    //To pass appropiate model data in viewholder onbindviewholder
    @Override
    public void onBindViewHolder(TheatreAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv_android.setText(moviesList1.get(i).getName());
       // Picasso.with(context).load(moviesList1.get(i).getTrailer().getThumbnail()).resize(100, 100).into(viewHolder.img_android);
//        Picasso.with(context).load(moviesList1.get(i).getTrailer().getThumbnail()).resize(100,100).into(viewHolder.img_android);

     try {

//Image downloader library, download an image from server
         Picasso.with(context).load(moviesList1.get(i).getTrailer().getThumbnail()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.img_android);
         viewHolder.img_android.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent in = new Intent(context,InfoActivity.class);
                 context.startActivity(in);

             }
         });
     }
     catch (NullPointerException e){
     }
    }
    @Override
    public int getItemCount() {
        return moviesList1.size();
    }

    //viewholder class is used to  instanitate the id
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_android;
        private ImageView img_android;
        public ViewHolder(View view) {
            super(view);
            tv_android = (TextView)view.findViewById(R.id.tv_android);
            img_android = (ImageView) view.findViewById(R.id.img_android);
            img_android.setScaleType(ImageView.ScaleType.FIT_XY);
            /*img_android.getLayoutParams().width=230;
            img_android.getLayoutParams().height=230;*/
        }
    }
}
