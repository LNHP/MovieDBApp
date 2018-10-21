package com.example.eastagile.themoviedatabase.repo.webservice.result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieTrailerResult {

    @SerializedName("id")
    private Integer id;

    @SerializedName("results")
    private List<MovieTrailerDto> results;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MovieTrailerDto> getResults() {
        return results;
    }

    public void setResults(List<MovieTrailerDto> results) {
        this.results = results;
    }

    public MovieTrailerResult(Integer id) {
        this.id = id;
    }
}
