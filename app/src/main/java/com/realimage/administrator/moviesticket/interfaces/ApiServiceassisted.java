package com.realimage.administrator.moviesticket.interfaces;

import com.realimage.administrator.moviesticket.model.Assistedmovieslist;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceassisted {
    @GET("/datapax/comingsoon.v2.json")
    Call<Assistedmovieslist> getMyJson();
}
