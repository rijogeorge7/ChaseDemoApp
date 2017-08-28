package com.rijo.chasedemoapp.data.domain;

/**
 * Created by rijogeorge on 8/28/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Song {

    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("song")
    @Expose
    private String song;
    @SerializedName("lyrics")
    @Expose
    private String lyrics;
    @SerializedName("url")
    @Expose
    private String url;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}