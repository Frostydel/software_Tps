interface MusicPlayer { boolean play(String artist, String title); }

class LegacyMusicPlayer {
    public int playTrack(String track) {
        if (track == null || track.trim().isEmpty()) return 0;
        System.out.println("[LEGACY PLAYER] " + track);
        return 1;
    }
}

class Track {
    private final String artist, title;
    Track(String artist, String title) { this.artist = artist; this.title = title; }
    String getArtist() { return artist; }
    String getTitle()  { return title; }
}

class StreamingPlayer {
    public boolean stream(Track track) {
        System.out.println("[STREAMING] " + track.getArtist() + " | " + track.getTitle());
        return true;
    }
}

class LegacyPlayerAdapter implements MusicPlayer {
    private final LegacyMusicPlayer legacy;
    LegacyPlayerAdapter(LegacyMusicPlayer legacy) { this.legacy = legacy; }
    @Override public boolean play(String artist, String title) {
        return legacy.playTrack(artist + " - " + title) == 1;
    }
}

class StreamingPlayerAdapter implements MusicPlayer {
    private final StreamingPlayer streaming;
    StreamingPlayerAdapter(StreamingPlayer streaming) { this.streaming = streaming; }
    @Override public boolean play(String artist, String title) {
        return streaming.stream(new Track(artist, title));
    }
}

public class Level1_Main {
    static void playSong(MusicPlayer player, String artist, String title) {
        System.out.println(player.play(artist, title) ? "Success" : "Failure");
    }
    public static void main(String[] args) {
        MusicPlayer p1 = new LegacyPlayerAdapter(new LegacyMusicPlayer());
        MusicPlayer p2 = new StreamingPlayerAdapter(new StreamingPlayer());
        playSong(p1, "Daft Punk", "Get Lucky");
        playSong(p1, "", "");            // test dial empty track
        playSong(p2, "Queen", "Bohemian Rhapsody");
    }
}
