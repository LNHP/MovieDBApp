package com.example.eastagile.themoviedatabase.repo;

import com.example.eastagile.themoviedatabase.repo.local.MoviePosterEntity;
import com.example.eastagile.themoviedatabase.repo.webservice.result.MovieResult;

import java.util.List;

import io.reactivex.Observable;

/**
 * Define Movie Repo function
 */

public interface MovieRepo {
    public Observable<List<MoviePosterEntity>> getMovieFavourite();

    public Observable<MovieResult> getMovieRemote();

}
