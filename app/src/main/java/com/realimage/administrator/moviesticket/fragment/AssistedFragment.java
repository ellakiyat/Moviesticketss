package com.realimage.administrator.moviesticket.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.realimage.administrator.moviesticket.adapter.Assistedadapter;
import com.realimage.administrator.moviesticket.interfaces.ApiServiceassisted;
import com.realimage.administrator.moviesticket.model.Assistedmovieslist;
import com.realimage.administrator.moviesticket.model.Assitedmovies;
import com.realimage.administrator.moviesticket.R;
import com.realimage.administrator.moviesticket.RetroClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class AssistedFragment extends Fragment {

    RecyclerView recyclerView;
    List<Assitedmovies> movieslist;
    //progress dialog
    private ProgressDialog progressBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View drawer = inflater.inflate(R.layout.assisted_fragment, container, false);
        recyclerView = (RecyclerView) drawer.findViewById(R.id.assisted_recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        progressBar = new ProgressDialog(getContext());
        progressBar.setCancelable(true);
        progressBar.setMessage("movies downloading....");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();
        //The REST adapter(RETROCLIENT) allows your store to communicate with an HTTP server by transmitting JSON
        //create an object of api interface
        ApiServiceassisted api = RetroClient.getApiServiceassisted();
        //caling json
        Call<Assistedmovieslist> call = api.getMyJson();

        //enqueue to make an asynchoronous request
        //enqueue callback will call get response

        call.enqueue(new Callback<Assistedmovieslist>() {
            @Override
            public void onResponse(Call<Assistedmovieslist> call, Response<Assistedmovieslist> response) {

                if (response.isSuccessful()) {
                    progressBar.dismiss();
                    //Get result from response.body
                    //result is an object
                    //onreponse and onfailure will be called in main thread.
                    movieslist = response.body().getMovies();
                    Assistedadapter adapter = new Assistedadapter(movieslist, getActivity());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Assistedmovieslist> call, Throwable t) {

                Toast.makeText(getActivity(),"No network connection is availabkle",Toast.LENGTH_SHORT).show();

            }
        });

        return drawer;
    }
}
