package projects.project5;

public class Song {
    private final String title;
    private final Artist artist;

    public Song(String title, Artist artist) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Song title cannot be empty.");
        }
        if (artist == null) {
            throw new IllegalArgumentException("Artist cannot be null.");
        }
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    // Cette valeur est stockee dans la List<String> de Playlist.
    public String asPlaylistEntry() {
        return title + " - " + artist.getName();
    }

    @Override
    public String toString() {
        return asPlaylistEntry();
    }
}
