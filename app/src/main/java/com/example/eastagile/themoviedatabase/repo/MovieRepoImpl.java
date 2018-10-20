package com.example.eastagile.themoviedatabase.repo;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.eastagile.themoviedatabase.repo.local.DBConstant;
import com.example.eastagile.themoviedatabase.repo.local.MovieDatabase;
import com.example.eastagile.themoviedatabase.repo.local.MovieLocalRepo;
import com.example.eastagile.themoviedatabase.repo.local.MovieLocalRepoImpl;
import com.example.eastagile.themoviedatabase.repo.local.MoviePosterEntity;
import com.example.eastagile.themoviedatabase.repo.webservice.MovieRemoteRepo;
import com.example.eastagile.themoviedatabase.repo.webservice.MovieRemoteRepoImpl;
import com.example.eastagile.themoviedatabase.repo.webservice.result.MovieResult;

import java.util.List;

import io.reactivex.Observable;

/**
 * Implement Movie Repository
 */

public class MovieRepoImpl implements MovieRepo {

    private static MovieRepo movieRepo;
    MovieLocalRepo localRepo;
    MovieRemoteRepo remoteRepo;

    private MovieRepoImpl(MovieLocalRepo localRepo, MovieRemoteRepo remoteRepo) {
        this.localRepo = localRepo;
        this.remoteRepo = remoteRepo;


    }

    public static MovieRepo getMovieRepoInstance(Context context) {
        if (null == movieRepo) {
            MovieRemoteRepo remoteRepo = new MovieRemoteRepoImpl();

            MovieDatabase movieDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    MovieDatabase.class, DBConstant.DB_NAME).build();

            MovieLocalRepo localRepo = new MovieLocalRepoImpl(movieDatabase.moviePosterDao());

            movieRepo = new MovieRepoImpl(localRepo, remoteRepo);
        }

        return movieRepo;
    }

    @Override
    public Observable<List<MoviePosterEntity>> getMovieFavourite() {
        return localRepo.getMovies();
    }

    @Override
    public Observable<MovieResult> getMovieRemote() {
        return remoteRepo.getMovies();
    }
}
