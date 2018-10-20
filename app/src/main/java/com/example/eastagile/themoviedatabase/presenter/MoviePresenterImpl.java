package com.example.eastagile.themoviedatabase.presenter;

import android.util.Log;

import com.example.eastagile.themoviedatabase.Utils;
import com.example.eastagile.themoviedatabase.repo.MovieRepo;
import com.example.eastagile.themoviedatabase.repo.RepoUtils;
import com.example.eastagile.themoviedatabase.repo.webservice.result.MovieResult;
import com.example.eastagile.themoviedatabase.view.MovieViewInterface;

import io.reactivex.observers.DisposableObserver;

/**
 * Implement Movie screen presenter
 */

public class MoviePresenterImpl implements MoviePresenter {

    private MovieRepo movieRepo;

    private MovieViewInterface movieViewInterface;


    public MoviePresenterImpl(MovieRepo movieRepo, MovieViewInterface viewInterface) {
        this.movieRepo = movieRepo;
        this.movieViewInterface = viewInterface;
    }


    @Override
    public void getAllMovies() {
        Log.d(Utils.LOG_TAG, "Enter MoviePresenter getAll()");
        movieRepo.getMovieRemote().subscribeWith(getObservable());
    }

    private DisposableObserver<MovieResult> getObservable() {
        return new DisposableObserver<MovieResult>() {
            @Override
            public void onNext(MovieResult moviePosterResult) {
                Log.d(Utils.LOG_TAG, "Enter MoviePresenter bind view data, totalPage: " + moviePosterResult.getTotalPages().toString());
                movieViewInterface.showMovies(RepoUtils.convertRemote(moviePosterResult));
            }

            @Override
            public void onError(Throwable e) {
                Log.d(Utils.LOG_TAG, "Enter MoviePresenter onError " + e);
            }

            @Override
            public void onComplete() {
                Log.d(Utils.LOG_TAG, "Enter MoviePresenter onComplete");
            }
        };
    }
}