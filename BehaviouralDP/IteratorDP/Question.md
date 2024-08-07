## Question:

### Implementing the Iterator Design Pattern for a Music Playlist

You are tasked with creating a music playlist application where users can add songs and iterate over the playlist to play them. Implement the Iterator design pattern to allow for traversing the playlist without exposing its underlying structure.

### Requirements:

1. **Song Class**:
    - Create a `Song` class with fields such as `String title` and `String artist`.
    - Provide appropriate constructor, getter, and setter methods.

2. **Playlist Interface**:
    - Create a `Playlist` interface with a method `Iterator createIterator()` that returns an `Iterator`.

3. **Iterator Interface**:
    - Create an `Iterator` interface with the following methods:
        - `boolean hasNext()`: Checks if there are more items to iterate over.
        - `Object next()`: Returns the next item in the collection.

4. **Concrete Playlist**:
    - Implement a class `MusicPlaylist` that represents a playlist of songs.
    - Provide methods to add songs to the playlist and to retrieve an iterator for the playlist.

5. **Concrete Iterator**:
    - Implement a class `MusicPlaylistIterator` that provides iteration over the `MusicPlaylist`.

6. **Testing**:
    - Create a test class `PlaylistTest` that demonstrates the use of the iterator to traverse through a playlist and access the songs.

### Example Usage:

```java
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
```

### Hints:

1. **Define the `Song` Class**:
    - Create the `Song` class with the following fields:
        - `String title`
        - `String artist`
    - Provide appropriate constructor to initialize these fields.
    - Implement getter methods for each field.

2. **Define the `Playlist` and `Iterator` Interfaces**:
    - **`Playlist` Interface**:
        - Define the `Playlist` interface with a method:
            - `Iterator createIterator()`: Returns an `Iterator` for traversing the playlist.
    - **`Iterator` Interface**:
        - Define the `Iterator` interface with the following methods:
            - `boolean hasNext()`: Checks if there are more items to iterate over.
            - `Object next()`: Returns the next item in the collection.

3. **Implement the `MusicPlaylist` Class**:
    - Create the `MusicPlaylist` class to manage a list of `Song` objects.
    - Provide methods to:
        - Add songs to the playlist.
        - Retrieve an iterator for the playlist using the `createIterator()` method.

4. **Implement the `MusicPlaylistIterator` Class**:
    - Create the `MusicPlaylistIterator` class that implements the `Iterator` interface.
    - Implement methods to:
        - `boolean hasNext()`: Check if there are more songs in the playlist.
        - `Object next()`: Return the next song from the playlist.

5. **Use the `PlaylistTest` Class**:
    - Create a `PlaylistTest` class to:
        - Instantiate the `MusicPlaylist` and add songs to it.
        - Use the `MusicPlaylistIterator` to traverse the playlist and access the songs.
