package com.example.eastagile.themoviedatabase.repo.webservice.result;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieReviewResult {

    @SerializedName("id")
    private Integer id;

    @SerializedName("page")
    private Integer page;

    @SerializedName("results")
    private List<MovieReviewDto> results;

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("total_results")
    private Integer totalResults;

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<MovieReviewDto> getResults() {
        return results;
    }

    public void setResults(List<MovieReviewDto> results) {
        this.results = results;
    }

    public MovieReviewResult(Integer id, Integer page, List<MovieReviewDto> results, Integer totalPages, Integer totalResults) {
        this.id = id;
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }
}
