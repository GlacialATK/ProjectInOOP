import javax.sound.sampled.*;
import java.io.File;

public class BGM {

    private static Clip clip;
    private static int volume = 70; // Default volume: 70%

    // Play background music
    public static void play() {

        try {

            // Prevent opening the same music multiple times
            if (clip != null && clip.isOpen()) {
                clip.start();
                return;
            }

            File musicFile = new File("src/sounds/Apocalypse.wav");

            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(musicFile);

            clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Apply saved volume
            setVolume(volume);

            // Loop music continuously
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            System.out.println("Error playing background music: " + e.getMessage());
        }
    }

    // Adjust volume (0-100)
    public static void setVolume(int newVolume) {

        volume = Math.max(0, Math.min(100, newVolume));

        if (clip != null && clip.isOpen()) {

            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {

                FloatControl gainControl =
                        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

                if (volume == 0) {
                    gainControl.setValue(gainControl.getMinimum());
                } else {

                    float gain = (float) (20 * Math.log10(volume / 100.0));

                    gain = Math.max(
                            gainControl.getMinimum(),
                            Math.min(gainControl.getMaximum(), gain)
                    );

                    gainControl.setValue(gain);
                }
            }
        }
    }

    // Get current volume
    public static int getVolume() {
        return volume;
    }

    // Stop background music
    public static void stop() {

        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    // Resume background music
    public static void resume() {

        if (clip != null && !clip.isRunning()) {
            clip.start();
        }
    }
}
