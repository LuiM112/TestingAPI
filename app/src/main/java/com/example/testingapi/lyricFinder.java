package com.example.testingapi;

import android.view.Display;

import java.util.List;

import models.Model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface lyricFinder {

    @GET("matcher.lyrics.get?")
    Call<List<Model>> getAllData(
            @Query("q_artist") String artist_search_parameter,
            @Query("q_track") String track_search_parameters,
            @Query("apikey") String apiKey
    );
}
