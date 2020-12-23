package DesignPatterns;

// Structural Design Pattern

// Adapter pattern works as a bridge between two incompatible interfaces.

// Problem:
//We have a MediaPlayer interface and a concrete class AudioPlayer implementing the MediaPlayer interface. AudioPlayer can play mp3 format audio files by default.
//We are having another interface AdvancedMediaPlayer and concrete classes implementing the AdvancedMediaPlayer interface. These classes can play vlc and mp4 format files.
//We want to make AudioPlayer to play other formats as well. To attain this, we have created an adapter class MediaAdapter which implements the MediaPlayer interface and
//...uses AdvancedMediaPlayer objects to play the required format.
//AudioPlayer uses the adapter class MediaAdapter passing it the desired audio type without knowing the actual class which can play the desired format. AdapterPatternDemo, our demo class will use AudioPlayer class to play various formats.
public class Adapter {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("MP3", "beyond the horizon.mp3");
        audioPlayer.play("VLC", "far far away.vlc");
        audioPlayer.play("MP4", "alone.mp4");
    }
}

interface MediaPlayer {
    void play(String audioType, String fileName);
}

interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMP4(String fileName);
}

class VlcPlayer implements  AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing VLC : " + fileName);
    }

    @Override
    public void playMP4(String fileName) {

    }
}

class MP4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMP4(String fileName) {
        System.out.println("Playing MP4 : " + fileName);
    }
}

class MediaAdapter implements  MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;
    MediaAdapter(String audioType) {
        if (audioType.equals("MP4")) {
            advancedMediaPlayer = new MP4Player();
        } else if (audioType.equals("VLC")) {
            advancedMediaPlayer = new VlcPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equals("MP4" )) {
            advancedMediaPlayer.playMP4(fileName);
        } else if (audioType.equals("VLC")) {
            advancedMediaPlayer.playVlc(fileName);
        }
    }
}

class AudioPlayer implements  MediaPlayer {
    MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equals("MP3")) {
            System.out.println(" playing mp3 file :" + fileName);
        } else if (audioType.equals("VLC") || audioType.equals("MP4")) {
                mediaAdapter = new MediaAdapter(audioType);
                mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

