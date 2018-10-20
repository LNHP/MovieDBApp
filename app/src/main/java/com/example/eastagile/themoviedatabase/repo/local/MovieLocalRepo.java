package com.example.eastagile.themoviedatabase.repo.local;

/**
 * Define the local repo function for public using
 */

import java.util.List;

public interface MovieLocalRepo {

    public io.reactivex.Observable<List<MoviePosterEntity>> getMovies();

    public void addMovies(List<MoviePosterEntity> items);

}
