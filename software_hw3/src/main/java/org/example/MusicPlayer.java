package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MusicPlayer {
    private Map<String, List<Song>> playlists;

    public MusicPlayer() {
        this.playlists = new HashMap<>();
    }
    public Map<String, List<Song>> getPlaylists() {
        return playlists;
    }
    public void addSong(Song song, String playlistName) {
        if (song != null && playlistName != null) {
            if (!playlists.containsKey(playlistName)) {
                playlists.put(playlistName, new ArrayList<>());
            }
            playlists.get(playlistName).add(song);
            System.out.println("Song added to playlist: " + playlistName);
        } else {
            System.out.println("Invalid song or playlist name.");
        }
    }
    public void removeSong(Song song, String playlistName) {
        if (song != null && playlistName != null) {
            if (playlists.containsKey(playlistName)) {
                boolean removed = playlists.get(playlistName).remove(song);
                if (removed)
                    System.out.println("Song removed from playlist: " + playlistName);
                else
                    System.out.println("Song not found in playlist: " + playlistName);
            } else {
                System.out.println("Playlist not found: " + playlistName);
            }
        } else {
            System.out.println("Invalid song or playlist name.");
        }
    }
    public void createPlaylist(String playlistName) {
        if (playlistName != null && !playlistName.isEmpty()) {
            if (!playlists.containsKey(playlistName)) {
                playlists.put(playlistName, new ArrayList<>());
                System.out.println("Playlist created: " + playlistName);
            } else {
                System.out.println("Playlist already exists: " + playlistName);
            }
        } else {
            System.out.println("Invalid playlist name.");
        }
    }
    public void displaySongsInPlaylist(String playlistName) {
        if (playlistName != null && !playlistName.isEmpty()) {
            if (playlists.containsKey(playlistName)) {
                System.out.println("Songs in playlist " + playlistName + ":");
                List<Song> songs = playlists.get(playlistName);
                for (Song song : songs) {
                    System.out.println("- " + song.getTitle() + " by " + song.getArtist());
                }
            } else {
                System.out.println("Playlist not found: " + playlistName);
            }
        } else {
            System.out.println("Invalid playlist name.");
        }
    }
}
