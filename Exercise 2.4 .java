import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Exercise4 extends JPanel {
    private static final int SUN_RADIUS = 50;
    private static final int PLANET_RADIUS = 30;
    private static final int ORBIT_RADIUS = 200;
    private static final int ROTATION_COUNT = 365;

    private double planetAngle = 0;

    public Exercise4() {
        Timer timer = new Timer(20, e -> {
            planetAngle += 2 * Math.PI / ROTATION_COUNT;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // matahari
        g2d.setColor(Color.BLACK);
        g2d.fill(new Ellipse2D.Double(ORBIT_RADIUS - SUN_RADIUS, ORBIT_RADIUS - SUN_RADIUS, 2 * SUN_RADIUS, 2 * SUN_RADIUS));

        // planet
        double planetX = ORBIT_RADIUS + ORBIT_RADIUS * Math.cos(planetAngle);
        double planetY = ORBIT_RADIUS - ORBIT_RADIUS * Math.sin(planetAngle); // Minus because y-axis is inverted

        // garis planet
        g2d.setColor(Color.WHITE);
        g2d.draw(new Ellipse2D.Double(0, 0, 2 * ORBIT_RADIUS, 2 * ORBIT_RADIUS));

        // planet
        g2d.setColor(Color.GREEN);
        g2d.fill(new Ellipse2D.Double(planetX - PLANET_RADIUS, planetY - PLANET_RADIUS, 2 * PLANET_RADIUS, 2 * PLANET_RADIUS));

        // point merah
        double pointX = planetX + PLANET_RADIUS * Math.cos(-planetAngle);
        double pointY = planetY + PLANET_RADIUS * Math.sin(-planetAngle); // Minus because y-axis is inverted
        g2d.setColor(Color.RED);
        g2d.fill(new Ellipse2D.Double(pointX - 3, pointY - 3, 6, 6));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Exercise4 animation = new Exercise4();
        frame.add(animation);
        frame.setSize(2 * ORBIT_RADIUS + 100, 2 * ORBIT_RADIUS + 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
