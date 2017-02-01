package com.realimage.administrator.moviesticket.interfaces;

import com.realimage.administrator.moviesticket.model.MoviesList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 11/27/2016.
 */

public interface ApiService {

    /*
    That use the Interfaces to perform a server request
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    To get the json
    */
    @GET("/datapax/JUSTICKETS.chennai.v1.json")
    Call<MoviesList> getMyJSON();

}
