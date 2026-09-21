package projects.project5;

public class PlaylistManagerApplication {
    public static void main(String[] args) {
        Artist stromae = new Artist("Stromae");
        Artist adele = new Artist("Adele");

        Song songOne = new Song("Alors on danse", stromae);
        Song songTwo = new Song("Hello", adele);

        Playlist playlist = new Playlist("My favorites");
        playlist.addSong(songOne);
        playlist.addSong(songTwo);

        playlist.printSongs();
        playlist.shuffle();

        System.out.println();
        System.out.println("After shuffle:");
        playlist.printSongs();
    }
}
