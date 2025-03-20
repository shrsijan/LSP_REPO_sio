package org.howard.edu.lsp.midterm.question5;

/**
 * The Streamable interface defines common behaviors for all media types.
 */
public interface Streamable {
    void play();
    void pause();
    void stop();
}
/**
 * The Music class represents a music media type that can be streamed.
 */
class Music implements Streamable {
    private String title;
    /**
     * Constructor initializes the music title.
     *
     * @param title The title of the music.
     */
    public Music(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing music: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused music: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped music: " + title);
    }

    /**
     * Adds the music to a playlist.
     *
     * @param playlistName The name of the playlist.
     */
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to " + playlistName + " playlist");
    }
}

/**
 * The Movie class represents a movie media type that can be streamed.
 */
class Movie implements Streamable {
    private String title;

    /**
     * Constructor initializes the movie title.
     *
     * @param title The title of the movie.
     */
    public Movie(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing movie: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused movie: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped movie: " + title);
    }

    /**
     * Rewinds the movie by a given number of seconds.
     *
     * @param seconds The number of seconds to rewind.
     */
    public void rewind(int seconds) {
        System.out.println("Rewinding movie: " + title + " by " + seconds + " seconds");
    }
}
/**
 * The Audiobook class represents an audiobook media type that can be streamed.
 */
class Audiobook implements Streamable {
    private String title;

    /**
     * Constructor initializes the audiobook title.
     *
     * @param title The title of the audiobook.
     */
    public Audiobook(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing audiobook: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused audiobook: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped audiobook: " + title);
    }

    /**
     * Sets the playback speed of the audiobook.
     *
     * @param speed The playback speed.
     */
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + title + " to " + speed + "x");
    }
}
