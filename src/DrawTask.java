import java.util.TimerTask;

public class DrawTask extends TimerTask {
    private Canvas canvas;

    public DrawTask(Frame frame) {
        this.canvas = frame.getCanvas();
    }

    @Override
    public void run() {
        long startingTime = System.currentTimeMillis();
        //this.canvas.paintComponent(this.canvas.getGraphics());
        this.canvas.draw();
        System.out.println(1000 / (System.currentTimeMillis() - startingTime));
    }
}
