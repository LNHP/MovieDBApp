package com.example.eastagile.themoviedatabase.view;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.eastagile.themoviedatabase.R;
import com.example.eastagile.themoviedatabase.Utils;
import com.example.eastagile.themoviedatabase.model.Movie;
import com.example.eastagile.themoviedatabase.presenter.MoviePresenter;
import com.example.eastagile.themoviedatabase.presenter.MoviePresenterImpl;
import com.example.eastagile.themoviedatabase.repo.MovieRepoImpl;

import java.util.List;

/**
 * This Activity handle Main Screen UI.
 * Show Movie poster in type of Popular, Rate, Favorite
 */

public class MainActivity extends AppCompatActivity implements MovieViewInterface {

    MovieFragment mPopularFragment;

    MoviePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Add fragment
        mPopularFragment = new MovieFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.movie_poster_fragment, mPopularFragment);
        ft.commit();

        mPresenter = new MoviePresenterImpl(MovieRepoImpl.getMovieRepoInstance(getApplicationContext()),
                this);
        mPresenter.getAllMovies();

    }

    @Override
    public void showMovies(List<Movie> dataList) {
        Log.d(Utils.LOG_TAG, "Enter MainActivity showMovies, dataSize: " + dataList.size());
        mPopularFragment.bindData(dataList);

    }
}
