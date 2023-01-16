import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {
    private NoiseGenerator noise;
    private BufferedImage image;
    private double time = 0, seed_inc = 0.05;


    public Canvas(NoiseGenerator noise) {
        super();
        this.noise = noise;
        image = new BufferedImage(Frame.DEFAULT_DIMENSION.width, Frame.DEFAULT_DIMENSION.height, BufferedImage.TYPE_INT_ARGB);
        this.draw();
    }


    public void draw() {
        double xoff, yoff, value, increment = 0.3;
        int RGB;
        Color c;

        yoff = 0;
        for (int i = 0; i < this.image.getHeight(); i++) {
            xoff = 0;
            for (int j = 0; j < this.image.getWidth(); j++) {
                value = ((noise.noise(xoff, yoff)) + 1) / 2;
                if (1 < value) {
                    value = 1;
                } else if (value < 0) {
                    value = 0;
                }

                RGB = (int) ((255) * (value));
                c = new Color(RGB, RGB, RGB);
                this.image.setRGB(j, i, c.getRGB());
                xoff += increment;
            }
            yoff += increment;
        }

        this.noise.setSeed(this.noise.getSeed() + seed_inc);
        this.repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.image, 0, 0, null);
    }
}
