package com.example.eastagile.themoviedatabase.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eastagile.themoviedatabase.R;
import com.example.eastagile.themoviedatabase.Utils;
import com.example.eastagile.themoviedatabase.adapter.MoviePosterAdapter;
import com.example.eastagile.themoviedatabase.model.Movie;

import java.util.List;

/**
 * This fragment handle the home screen movie poster list
 */

public class MovieFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private MoviePosterAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate view
        View view = inflater.inflate(R.layout.fragment_poster_items_list, container, false);
        mRecyclerView = view.findViewById(R.id.rcv_movie_poster);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        // Tablayout
        TabLayout tabLayout = view.findViewById(R.id.tablayout_movie_poster);
        tabLayout.addTab(tabLayout.newTab().setText("Popular"));
        tabLayout.addTab(tabLayout.newTab().setText("Popular"));
        tabLayout.addTab(tabLayout.newTab().setText("Popular"));

        return view;
    }

    public void bindData(List<Movie> dataList) {
        Log.d(Utils.LOG_TAG, "Enter MovieFragment bindData, listSize: " + dataList.size());
        if (null != dataList) {
            mAdapter = new MoviePosterAdapter(dataList);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        }
    }
}
