package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("lyrics")
    @Expose
    private String lyrics;

    @SerializedName("lyrics_body")
    @Expose
    private String lyrics_body;

    public String getMessage() {
        return message;
    }

    public String getBody() {
        return body;
    }

    public String getLyrics() {
        return lyrics;
    }

    public String getLyrics_body() {
        return lyrics_body;
    }
}
