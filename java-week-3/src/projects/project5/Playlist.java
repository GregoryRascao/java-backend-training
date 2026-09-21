package projects.project5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private final String name;
    // L'enonce demande une List<String>; chaque chaine contient le titre
    // et l'artiste de la chanson.
    private final List<String> songs = new ArrayList<>();

    public Playlist(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Playlist name cannot be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song cannot be null.");
        }

        String playlistEntry = song.asPlaylistEntry();
        if (songs.contains(playlistEntry)) {
            throw new IllegalArgumentException("This song is already in the playlist.");
        }
        songs.add(playlistEntry);
    }

    public void removeSong(Song song) {
        if (song == null || !songs.remove(song.asPlaylistEntry())) {
            throw new IllegalArgumentException("This song is not in the playlist.");
        }
    }

    public void shuffle() {
        Collections.shuffle(songs);
    }

    public List<String> getSongs() {
        return Collections.unmodifiableList(songs);
    }

    public void printSongs() {
        System.out.println("Playlist: " + name);
        for (String song : songs) {
            System.out.println("- " + song);
        }
    }
}
