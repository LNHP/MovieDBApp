package com.example.eastagile.themoviedatabase.adapter;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eastagile.themoviedatabase.R;
import com.example.eastagile.themoviedatabase.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * The movie poster adapter, handle poster views with popular | rate | favorite
 */

public class MoviePosterAdapter extends RecyclerView.Adapter<MoviePosterAdapter.MoviePosterViewHolder> {

    private List<Movie> dataList;

    public MoviePosterAdapter(List<Movie> data) {
        this.dataList = data;
    }

    @NonNull
    @Override
    public MoviePosterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_poster_item, viewGroup, false);
        MoviePosterViewHolder posterViewHolder = new MoviePosterViewHolder(view);
        return posterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviePosterViewHolder viewHolder, int pos) {
        Movie item = dataList.get(pos);
        viewHolder.tvTitle.setText(item.getTitle());
        if (item.isFavorite()) {
            viewHolder.imvFavourite.setImageDrawable(ContextCompat.getDrawable(viewHolder.mView.getContext(), R.drawable.btn_favourite_on));
        } else {
            viewHolder.imvFavourite.setImageDrawable(ContextCompat.getDrawable(viewHolder.mView.getContext(), R.drawable.btn_favourite_off));
        }
        viewHolder.loadPosterImage(item.getPosterPath());
    }

    @Override
    public int getItemCount() {
        return null == dataList ? 0 : dataList.size();
    }

    public class MoviePosterViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        TextView tvTitle;

        ImageView imvPoster;
        ImageView imvFavourite;

        public MoviePosterViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
            tvTitle = mView.findViewById(R.id.tv_poster_title);
            imvPoster = mView.findViewById(R.id.imv_poster);
            imvFavourite = mView.findViewById(R.id.imv_poster_favourite);
        }

        public void loadPosterImage(String url) {
            Picasso.with(itemView.getContext())
                    .load(url)
                    .placeholder(R.drawable.progress_animation)
                    .into(imvPoster);
        }
    }
}
