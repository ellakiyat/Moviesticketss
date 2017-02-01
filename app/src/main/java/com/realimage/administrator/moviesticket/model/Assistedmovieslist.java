package com.realimage.administrator.moviesticket.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Assistedmovieslist {

    //To get all the item in the array list

   @SerializedName("movies")
   @Expose
   private ArrayList<Assitedmovies> movies = new ArrayList<Assitedmovies>();

    public ArrayList<Assitedmovies> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Assitedmovies> movies) {
        this.movies = movies;
    }
}
