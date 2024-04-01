package org.example;

public class Song {
    private String artist;
    private String title;
    private int durationInSeconds;
    private String album;

    public Song(String artist, String title, int durationInSeconds, String album) {
        this.artist = artist;
        this.title = title;
        this.durationInSeconds = durationInSeconds;
        this.album = album;
    }
    public String getArtist() {
        return artist;
    }
    public String getTitle() {
        return title;
    }
    public int getDurationInSeconds() {
        return durationInSeconds;
    }
    public String getAlbum() {
        return album;
    }

}
