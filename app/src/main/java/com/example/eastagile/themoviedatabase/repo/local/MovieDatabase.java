package com.example.eastagile.themoviedatabase.repo.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {MoviePosterEntity.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {
    public abstract MoviePosterDao moviePosterDao();

}
