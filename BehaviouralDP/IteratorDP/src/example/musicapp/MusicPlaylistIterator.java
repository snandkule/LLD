package example.musicapp;

import java.util.List;

public class MusicPlaylistIterator implements Iterator<Song>{
    List<Song> songs;
    int currentIndex;
    public MusicPlaylistIterator(List<Song> songs){
        this.songs = songs;
        this.currentIndex = 0;
    }
    @Override
    public boolean hasNext() {
        return currentIndex<songs.size();
    }

    @Override
    public Song next() {
        return songs.get(currentIndex++);
    }
}
