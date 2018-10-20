package com.example.eastagile.themoviedatabase.repo.local;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;

/**
 * Implement the local repository
 */

public class MovieLocalRepoImpl implements MovieLocalRepo {

    private MoviePosterDao moviePosterDao;

    public MovieLocalRepoImpl(MoviePosterDao moviePosterDao) {
        this.moviePosterDao = moviePosterDao;
    }

    /**
     * Get all user favorite movie
     *
     * @return favorite movie list
     */
    @Override
    public Observable<List<MoviePosterEntity>> getMovies() {
        // Todo
        return Observable.fromCallable(new Callable<List<MoviePosterEntity>>() {
            @Override
            public List<MoviePosterEntity> call() throws Exception {
                return moviePosterDao.getAll();
            }
        });


    }

    @Override
    public void addMovies(List<MoviePosterEntity> items) {
        moviePosterDao.insertAll(items);
    }
}
