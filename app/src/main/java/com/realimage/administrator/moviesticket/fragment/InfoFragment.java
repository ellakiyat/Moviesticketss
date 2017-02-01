package com.realimage.administrator.moviesticket.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.realimage.administrator.moviesticket.R;
import com.realimage.administrator.moviesticket.RetroClient;
import com.realimage.administrator.moviesticket.adapter.InfoAdapter;
import com.realimage.administrator.moviesticket.interfaces.ApiService;
import com.realimage.administrator.moviesticket.model.Movies;
import com.realimage.administrator.moviesticket.model.MoviesList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class InfoFragment extends Fragment {
    RecyclerView recyclerView;
    List<Movies> infomovies;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View info = inflater.inflate(R.layout.info_fragment, container, false);
        final TextView datetv = (TextView) info.findViewById(R.id.datetextview);
        final TextView infotv = (TextView) info.findViewById(R.id.infotextview);
     /*   final TextView castlitv= (TextView) info.findViewById(R.id.castlitextview);
        TextView crewlitv= (TextView) info.findViewById(R.id.crewlitextview);*/
        /*recyclerView= (RecyclerView) info.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);*/
        ApiService api = RetroClient.getApiService();
        //calling json
        Call<MoviesList> call = api.getMyJSON();
        //Enqueue to make an asynchoronous request
        //enqueue callback will call to get json response
        call.enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                if (response.isSuccessful()) {
                    //dialog.dismiss();
                    //Get result from response.body
                    //result is an object
                    //onreponse and onfailure will be called in main thread.
                    infomovies = response.body().getMovies();
                    for(int i=0;i<infomovies.size();i++){
                        System.out.println(infomovies.get(i));
                        datetv.setText(infomovies.get(i).getRelease());
                        infotv.setText(infomovies.get(i).getSynopsis());
                        InfoAdapter infoadpter = new InfoAdapter(infomovies,getActivity());
                        recyclerView.setAdapter(infoadpter);
                    }
                }
            }
            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {

                Toast.makeText(getActivity(), "Network is not connected", Toast.LENGTH_SHORT).show();
            }
        });
        return info;
    }
}
