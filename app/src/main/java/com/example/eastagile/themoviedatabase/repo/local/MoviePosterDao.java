package com.example.eastagile.themoviedatabase.repo.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MoviePosterDao {

    @Query("SELECT * FROM " + DBConstant.FAVOURITE_TABLE_NAME)
    List<MoviePosterEntity> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MoviePosterEntity> items);

}
