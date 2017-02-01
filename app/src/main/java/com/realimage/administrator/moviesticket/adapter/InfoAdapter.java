package com.realimage.administrator.moviesticket.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.realimage.administrator.moviesticket.model.Movies;
import com.squareup.picasso.Picasso;
import java.util.List;
import com.realimage.administrator.moviesticket.R;
public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {
    private List<Movies> moviesList1;
    private Context context;
    //create constructor
    public InfoAdapter(List<Movies> moviesList1, Context context) {
        this.moviesList1 = moviesList1;
        this.context = context;
    }
    //To inflate the xml file
    @Override
    public InfoAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.castlayout, viewGroup, false);
        return new ViewHolder(view);
    }
    //To pass appropiate model data in viewholder onbindviewholder
    @Override
    public void onBindViewHolder(InfoAdapter.ViewHolder viewHolder, int i) {
        viewHolder.name_testview.setText(moviesList1.get(i).cast.get(i).name);
        viewHolder.role_testview.setText(moviesList1.get(i).cast.get(i).role);
        // Picasso.with(context).load(moviesList1.get(i).getTrailer().getThumbnail()).resize(100, 100).into(viewHolder.img_android);
        //  Picasso.with(context).load(moviesList1.get(i).getTrailer().getThumbnail()).resize(100,100).into(viewHolder.img_android);
        //Image downloader library, download an image from server
        Picasso.with(context).load(moviesList1.get(i).cast.get(i).posterUrl).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.post_imageview);
    }
    @Override
    public int getItemCount() {
        return moviesList1.size();
    }

    //viewholder class is used to  instanitate the id
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name_testview;
        private TextView role_testview;
        private ImageView post_imageview;

        public ViewHolder(View view) {
            super(view);
            name_testview = (TextView) view.findViewById(R.id.nametextview);
            role_testview = (TextView) view.findViewById(R.id.roletextview);
            post_imageview = (ImageView) view.findViewById(R.id.postimageview);
        }
    }
}

