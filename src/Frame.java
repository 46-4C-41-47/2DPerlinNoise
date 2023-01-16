import javax.swing.*;
import java.awt.*;
public class Frame extends JFrame {
    public static final Dimension DEFAULT_DIMENSION = new Dimension(700, 700);
    private NoiseGenerator noise;
    private Canvas canvas;


    public Frame(NoiseGenerator noise) {
        super();
        this.noise = noise;
        this.canvas = new Canvas(this.noise);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(DEFAULT_DIMENSION);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        this.add(this.canvas, BorderLayout.CENTER);

        this.setVisible(true);
    }


    public Canvas getCanvas() {
        return this.canvas;
    }
}
