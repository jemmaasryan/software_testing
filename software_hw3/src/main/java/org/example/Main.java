package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();

        Song song1 = new Song("Taylor", "Enchanted", 352, "Speak Now");
        Song song2 = new Song("Maneskin", "Timezone", 180, "Rush");
        Song song3 = new Song("Adele", "Set fire to the rain", 240, "21");

        musicPlayer.createPlaylist("Favourites");
        musicPlayer.addSong(song1, "Favourites");
        musicPlayer.addSong(song2, "Favourites");
        musicPlayer.addSong(song3, "Favourites");

        musicPlayer.displaySongsInPlaylist("Favourites");


        musicPlayer.removeSong(song2, "Favourites");
        musicPlayer.displaySongsInPlaylist("Favourites");

        musicPlayer.removeSong(song2, "Favourites");
    }
}