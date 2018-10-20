package com.example.eastagile.themoviedatabase.repo.webservice;

import android.util.Log;

import com.example.eastagile.themoviedatabase.Utils;
import com.example.eastagile.themoviedatabase.repo.RepoUtils;
import com.example.eastagile.themoviedatabase.repo.webservice.network.MovieBaseRemote;
import com.example.eastagile.themoviedatabase.repo.webservice.network.MovieDBService;
import com.example.eastagile.themoviedatabase.repo.webservice.result.MovieResult;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Implement Movie Network Repository
 */
public class MovieRemoteRepoImpl extends MovieBaseRemote implements MovieRemoteRepo {

    @Override
    public Observable<MovieResult> getMovies() {
        Log.d(Utils.LOG_TAG, "Enter MovieRemoteRepo ");
        return getRetrofitInstance().create(MovieDBService.class)
                .getMovies(RepoUtils.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

