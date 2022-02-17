package com.example.testingapi;

import models.Data;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface lyricFinder {

    @GET("matcher.lyrics.get?format=json&callback=callback&")
    Call<Data> getAllData(
            @Query("q_artist=") String artist_search_parameter,
            @Query("q_track=") String track_search_parameters
    );
}
