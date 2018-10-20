package com.example.eastagile.themoviedatabase.repo;

import com.example.eastagile.themoviedatabase.BuildConfig;
import com.example.eastagile.themoviedatabase.model.Movie;
import com.example.eastagile.themoviedatabase.repo.local.MoviePosterEntity;
import com.example.eastagile.themoviedatabase.repo.webservice.result.MovieDto;
import com.example.eastagile.themoviedatabase.repo.webservice.result.MovieResult;

import java.util.ArrayList;
import java.util.List;

public final class RepoUtils {

    public static final String API_KEY = BuildConfig.API_KEY;
    public static final String POSTER_PREFIX = "https://image.tmdb.org/t/p/w500";

    public static List<Movie> convertLocal(List<MoviePosterEntity> listIn) {
        // Todo
        return null;
    }

    /**
     * Convert Web API data to model, which can be use for UI view
     *
     * @param result Web API data
     * @return list of Movie data
     */
    public static List<Movie> convertRemote(MovieResult result) {
        List<Movie> dataList = new ArrayList<Movie>();

        if (null == result || null == result.getResults()) {
            return dataList;
        }

        for (MovieDto movieDto : result.getResults()) {
            Movie movie = new Movie(movieDto.getId(),
                    movieDto.getTitle(),
                    getFullMoviePosterPath(movieDto.getPosterPath()),
                    movieDto.getVoteAverage(),
                    movieDto.getReleaseDate(),
                    movieDto.getOverview(),
                    getFavouriteState(movieDto.getId()));
            dataList.add(movie);
        }

        return dataList;
    }

    private static boolean getFavouriteState(Integer id) {
        // Todo init
        return false;
    }

    private static String getFullMoviePosterPath(String posterPath) {
        return POSTER_PREFIX.concat(posterPath);
    }
}
