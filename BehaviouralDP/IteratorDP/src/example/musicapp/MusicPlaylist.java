package example.musicapp;

import java.util.ArrayList;
import java.util.List;

public class MusicPlaylist implements Playlist{
    private List<Song> songs;

    public MusicPlaylist(){
        songs= new ArrayList<>();
    }

    public void addSong(Song song){
        songs.add(song);
    }
    @Override
    public Iterator createIterator() {
        return new MusicPlaylistIterator(songs);
    }
}
