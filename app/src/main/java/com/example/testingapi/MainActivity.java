package com.example.testingapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import models.Model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String format = "matcher.lyrics.get?format=json&callback=callback&";
    private static final String artist_search_parameter = "&q_artist=";
    private static final String track_search_parameter = "&q_track=";

    private ApiKey key;

    private EditText artist_text;
    private EditText song_text;
    private Button search;
    private String artistString;
    private String songString;
    private String apiKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search = findViewById(R.id.button);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                artist_text = findViewById(R.id.artist_name);
                artistString = artist_text.getText().toString();
                Log.e(TAG, "onCreate: String" + artistString);
                song_text = findViewById(R.id.song_name);
                songString = song_text.getText().toString();
                Log.e(TAG, "onCreate: String" + songString);
                apiKey = key.getKey();
                lyricFinder lf = retrofitClient.getRetrofitInstance().create(lyricFinder.class);
                Call<List<Model>> call = lf.getAllData(artistString,songString,apiKey);

                call.enqueue(new Callback<List<Model>>() {
                    @Override
                    public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                        Log.e(TAG, "onResponse: code :" + response.code() );

                        List<Model> info = response.body();

                        for (Model info1 : info){
                            Log.e(TAG, "onResponse: body" + info1.getLyricsBody() );
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Model>> call, Throwable t) {

                    }
                });

            }
        });
    }
}