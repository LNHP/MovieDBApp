package com.example.eastagile.themoviedatabase.repo.webservice.network;

import com.example.eastagile.themoviedatabase.repo.webservice.result.MovieResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Define Network connection function
 */

public interface MovieDBService {

    @GET("discover/movie")
    Observable<MovieResult> getMovies(@Query("api_key") String api_key);


}
