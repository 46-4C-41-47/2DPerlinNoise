import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        int frameRate = 30;

        NoiseGenerator noise = new NoiseGenerator(0);
        Frame frame = new Frame(noise);

        Timer timer = new Timer(true);
        DrawTask drawTask = new DrawTask(frame);
        timer.scheduleAtFixedRate(drawTask, 0, 1000/frameRate);
    }
}
