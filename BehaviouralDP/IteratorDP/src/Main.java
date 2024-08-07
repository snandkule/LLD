import example.musicapp.Iterator;
import example.musicapp.MusicPlaylist;
import example.musicapp.Song;

public class Main {
    public static void main(String[] args) {
        // Create a playlist and add songs
        MusicPlaylist playlist = new MusicPlaylist();
        playlist.addSong(new Song("Imagine", "John Lennon"));
        playlist.addSong(new Song("Bohemian Rhapsody", "Queen"));
        playlist.addSong(new Song("Hotel California", "Eagles"));

        // Create an iterator and iterate over the playlist
        Iterator iterator = playlist.createIterator();
        while (iterator.hasNext()) {
            Song song = (Song) iterator.next();
            System.out.println("Title: " + song.getTitle() + ", Artist: " + song.getArtist());
        }
    }
}
