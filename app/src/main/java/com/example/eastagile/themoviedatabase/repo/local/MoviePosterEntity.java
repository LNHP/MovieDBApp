package com.example.eastagile.themoviedatabase.repo.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = DBConstant.FAVOURITE_TABLE_NAME)
public class MoviePosterEntity {
    @PrimaryKey
    @ColumnInfo(name = DBConstant.MOVIE_ID)
    private int id;
    @ColumnInfo(name = DBConstant.MOVIE_TITLE)
    private String title;
    @ColumnInfo(name = DBConstant.MOVIE_POSTER_PATH)
    private String posterPath;
    @ColumnInfo(name = DBConstant.VOTE_AVERAGE)
    private float voteAverage;
    @ColumnInfo(name = DBConstant.RELEASE_DATE)
    private String releaseDate;
    @ColumnInfo(name = DBConstant.OVERVIEW)
    private String overview;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

}
