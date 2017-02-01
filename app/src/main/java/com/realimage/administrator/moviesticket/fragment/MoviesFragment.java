package com.realimage.administrator.moviesticket.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.realimage.administrator.moviesticket.adapter.TheatreAdapter;
import com.realimage.administrator.moviesticket.interfaces.ApiService;
import com.realimage.administrator.moviesticket.model.Movies;
import com.realimage.administrator.moviesticket.model.MoviesList;
import com.realimage.administrator.moviesticket.R;
import com.realimage.administrator.moviesticket.RetroClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesFragment extends Fragment {
    RecyclerView recyclerView;
    List<Movies> moviesList;
    //    ProgressDialog dialog;
    private ProgressDialog progressBar;
    private int progressBarstatus = 0;
    ViewPager viewPager;
    FloatingActionButton actionButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vv = inflater.inflate(R.layout.movie_fragment, container, false);
        viewPager = (ViewPager) vv.findViewById(R.id.backdrops_pager);
        actionButton = (FloatingActionButton) vv.findViewById(R.id.fab);
        recyclerView = (RecyclerView) vv.findViewById(R.id.recycler_movie_suggestion);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        progressBar = new ProgressDialog(vv.getContext());
        progressBar.setCancelable(true);
        progressBar.setMessage("movies downloading....");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();
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
                    progressBar.dismiss();
                    //Get result from response body
                    //result is an object
                    //onreponse and onfailure will be called in main thread.
                    moviesList = response.body().getMovies();
                    PagerAdapter pagerAdapter = new com.realimage.administrator.moviesticket.adapter.PagerAdapter(moviesList, getActivity());
                    viewPager.setAdapter(pagerAdapter);
                    TheatreAdapter adapter = new TheatreAdapter(moviesList, getActivity());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
                Toast.makeText(getActivity(), "Data is not fetching", Toast.LENGTH_SHORT).show();
            }
        });

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(actionButton, "rotation", 360f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(actionButton, "rotation", 360f);
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(anim1, anim2);
        set1.setDuration(2000);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(
                ObjectAnimator.ofFloat(actionButton, "scaleX", 0f, 1f)
                        .setDuration(2000),
                ObjectAnimator.ofFloat(actionButton, "scaleY", 0f, 1f)
                        .setDuration(2000)
        );
        ObjectAnimator fadeout = ObjectAnimator.ofFloat(actionButton, "alpha", 1f, .2F);
        fadeout.setDuration(2000);
        ObjectAnimator fadein = ObjectAnimator.ofFloat(actionButton, "alpha", .2f, 1f);
        fadein.setDuration(2000);
        final AnimatorSet set3 = new AnimatorSet();
        set3.play(fadein).after(fadeout);
        set3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                set3.start();
            }
        });
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(actionButton, "translationY", -200f);
        animator1.setRepeatCount(0);
        animator1.setDuration(1000);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(actionButton, "translationY", 100f);
        animator2.setRepeatCount(0);
        animator2.setDuration(1000);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(actionButton, "translationY", 0f);
        animator3.setRepeatCount(0);
        animator3.setDuration(1000);
        //sequencial animation
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).before(animator2);
        set.play(animator2).before(animator3);
        ObjectAnimator rota = ObjectAnimator.ofFloat(actionButton, "rotation", 0, 360);
        rota.setDuration(2000);
        final AnimatorSet rot = new AnimatorSet();
        rot.play(rota);
        rot.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                rot.start();
            }
        });
        AnimatorSet set5 = new AnimatorSet();
        set5.playSequentially(set1, set2, set3, set, rot);
        set5.start();

        return vv;
    }
}
//synchornous request block the client until operation complete, javascript engine the browser is blocked, networkonmainthread exception error occur
//Asynchoronous request doesnot block the client, browser is responsive,at the time, user can perform another operation also
//thread defines a process runing, main thread(ui thread) in android and all other thread run in background
//Oncreateview() ----> when the fragment has to create its view hierarchy. During this method we will inflate our layout inside the fragment
//sethasfixed size  all items are of the same size
//getactivity() gives the context of the activity
//The REST adapter(RETROCLIENT) allows your store to communicate with an HTTP server by transmitting JSON
//create an object of api interface
//Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object.
