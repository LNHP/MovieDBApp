package com.example.eastagile.themoviedatabase.repo.webservice;

import com.example.eastagile.themoviedatabase.repo.webservice.result.MovieResult;

/**
 * Define Network movie repository function
 */

public interface MovieRemoteRepo {

    public io.reactivex.Observable<MovieResult> getMovies();

}
