package com.realimage.administrator.moviesticket;

import com.realimage.administrator.moviesticket.interfaces.ApiService;
import com.realimage.administrator.moviesticket.interfaces.ApiServiceassisted;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {

    /********
     * step 1: Here i used that URLS and fetch the data from server
     *******/
    private static final String ROOT_URL = "https://d1n1a8bo7yrjlf.cloudfront.net";
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @Return API Service
     */
    public static ApiServiceassisted getApiServiceassisted() {
        return getRetrofitInstance().create(ApiServiceassisted.class);
    }

    public static ApiService getApiService() {

        return getRetrofitInstance().create(ApiService.class);
    }

}
/**
 * step 2:Get Retrofit Instance
 * To send out network requests to an API, we need to use the Retrofit builder class and specify the base URL for the service.
 */
//using gson to fetch and parse json into java models
//gsonconverterfacxtory()---
//GsonConverter is included in the package and is automatically initiated upon RestAdapter creation.
// As a result, the json result from server would be automatically parsed to the defined Data Access Object (DAO)
//Retrofit 2 now supports many different parsers for processing network response data, gson converter for now