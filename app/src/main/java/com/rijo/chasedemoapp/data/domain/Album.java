package com.rijo.chasedemoapp.data.domain;

/**
 * Created by rijogeorge on 8/28/17.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("album")
    @Expose
    private String album;
    @SerializedName("year")
    @Expose
    private Object year;
    @SerializedName("amazonLink")
    @Expose
    private String amazonLink;
    @SerializedName("songs")
    @Expose
    private List<String> songs = null;

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Object getYear() {
        return year;
    }

    public void setYear(Object year) {
        this.year = year;
    }

    public String getAmazonLink() {
        return amazonLink;
    }

    public void setAmazonLink(String amazonLink) {
        this.amazonLink = amazonLink;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

}