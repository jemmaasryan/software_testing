import java.util.List;
import java.util.Map;
import org.example.MusicPlayer;
import org.example.Song;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MusicPlayerTest {

    @Test
    public void testAddSongValid() {
        MusicPlayer musicPlayer = new MusicPlayer();
        Song song = new Song("Eminem", "Beautiful", 245, "Relapse");
        String playlistName = "Favourites";

        musicPlayer.addSong(song, playlistName);

        Map<String, List<Song>> playlists = musicPlayer.getPlaylists();
        assertTrue(playlists.containsKey(playlistName));
        assertEquals(1, playlists.get(playlistName).size());
        assertEquals(song, playlists.get(playlistName).get(0));
    }

    @Test
    public void testAddSongInvalidSong() {
        MusicPlayer musicPlayer = new MusicPlayer();
        Song song = null; // Invalid song
        String playlistName = "Favourites";

        musicPlayer.addSong(song, playlistName);

        Map<String, List<Song>> playlists = musicPlayer.getPlaylists();
        assertFalse(playlists.containsKey(playlistName));
    }

    @Test
    public void testAddSongInvalidPlaylist() {
        MusicPlayer musicPlayer = new MusicPlayer();
        Song song = new Song("Eminem", "Mockingbird", 250, "Encore");
        String playlistName = null; // Invalid playlist name

        musicPlayer.addSong(song, playlistName);

        Map<String, List<Song>> playlists = musicPlayer.getPlaylists();
        assertFalse(playlists.containsKey(playlistName));
    }
    @Test
    public void testRemoveSongValid() {
        MusicPlayer musicPlayer = new MusicPlayer();
        Song song = new Song("Taylor", "Enchanted", 352, "Speak Now");
        String playlistName = "Favourites";

        musicPlayer.addSong(song, playlistName);

        musicPlayer.removeSong(song, playlistName);

        // Verify song removal
        Map<String, List<Song>> playlists = musicPlayer.getPlaylists();
        assertFalse(playlists.get(playlistName).contains(song));;
    }
    @Test
    public void testRemoveSongNotFound() {
        MusicPlayer musicPlayer = new MusicPlayer();
        Song song = new Song("Adele", "Skyfall", 289, "Skyfall");
        String playlistName = "Recent";
        musicPlayer.removeSong(song, playlistName);

        System.out.println("Song not found in playlist: " + playlistName);
    }
    @Test
    public void testRemoveSongInvalidSong() {
        MusicPlayer musicPlayer = new MusicPlayer();
        Song song = null; // Invalid song
        String playlistName = "Favourites";

        musicPlayer.removeSong(song, playlistName);
    }
    @Test
    public void testRemoveSongInvalidPlaylist() {
        MusicPlayer musicPlayer = new MusicPlayer();
        Song song = new Song("Adele", "Skyfall", 289, "Skyfall");
        String playlistName = null; // Invalid playlist name

        musicPlayer.removeSong(song, playlistName);
    }
    @Test
    public void testCreatePlaylistValid() {
        MusicPlayer musicPlayer = new MusicPlayer();
        String playlistName = "Summer vibes";

        musicPlayer.createPlaylist(playlistName);

        Map<String, List<Song>> playlists = musicPlayer.getPlaylists();
        assertTrue(playlists.containsKey(playlistName));
        assertTrue(playlists.get(playlistName).isEmpty());
    }
    @Test
    public void testCreatePlaylistAlreadyExists() {
        MusicPlayer musicPlayer = new MusicPlayer();
        String playlistName = "Favourites";

        musicPlayer.createPlaylist(playlistName);

        musicPlayer.createPlaylist(playlistName);
        Map<String, List<Song>> playlists = musicPlayer.getPlaylists();
        assertTrue(playlists.containsKey(playlistName));
        assertEquals(1, playlists.size()); // only one playlist should be  present
        assertEquals(0, playlists.get(playlistName).size()); // the laylist should be empty
    }
    @Test
    public void testCreatePlaylistInvalidName() {
        MusicPlayer musicPlayer = new MusicPlayer();
        String playlistName = null; // invalid playlist name

        musicPlayer.createPlaylist(playlistName);

        Map<String, List<Song>> playlists = musicPlayer.getPlaylists();
        assertFalse(playlists.containsKey(playlistName));
    }

    @Test
    public void testDisplaySongsInPlaylistValid() {
        MusicPlayer musicPlayer = new MusicPlayer();
        String playlistName = "Summer";
        Song song1 = new Song("Harry Styles", "Watermelon sugar", 189, "Fine Line");
        Song song2 = new Song("Harry Styles", "Golden", 209, "Fine Line");

        // Adding new songs to the playlist, so we can display them
        musicPlayer.addSong(song1, playlistName);
        musicPlayer.addSong(song2, playlistName);

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        musicPlayer.displaySongsInPlaylist(playlistName);

        System.setOut(System.out);

        String expectedOutput = "Songs in playlist Summer:" + System.lineSeparator() +
                "- Watermelon sugar by Harry Styles" + System.lineSeparator() +
                "- Golden by Harry Styles" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }
    @Test
    public void testDisplaySongsInPlaylistPlaylistNotFound() {
        MusicPlayer musicPlayer = new MusicPlayer();
        String playlistName = "Nonexistent Playlist";

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        musicPlayer.displaySongsInPlaylist(playlistName);

        System.setOut(System.out);

        assertEquals("Playlist not found: Nonexistent Playlist" + System.lineSeparator(), outputStream.toString());
    }
    @Test
    public void testDisplaySongsInPlaylistInvalidName() {
        MusicPlayer musicPlayer = new MusicPlayer();
        String playlistName = null; // Invalid playlist name

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        musicPlayer.displaySongsInPlaylist(playlistName);
        System.setOut(System.out);

        assertEquals("Invalid playlist name." + System.lineSeparator(), outputStream.toString());
    }
}