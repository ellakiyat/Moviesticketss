package com.realimage.administrator.moviesticket.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MoviesList {
    //To get all the item in the arraylist
    @SerializedName("movies")
    @Expose
    private ArrayList<Movies> movies = new ArrayList<Movies>();

    public ArrayList<Movies> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movies> movies) {
        this.movies = movies;
    }
}
