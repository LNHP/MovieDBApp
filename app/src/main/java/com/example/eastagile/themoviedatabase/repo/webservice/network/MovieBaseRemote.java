package com.example.eastagile.themoviedatabase.repo.webservice.network;

import android.util.Log;

import com.example.eastagile.themoviedatabase.Utils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Implement Network connection with URL
 */

public class MovieBaseRemote {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        Log.d(Utils.LOG_TAG, "Enter MovieBaseRemote");
        if (null == retrofit) {
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
