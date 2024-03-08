import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Exercise6 extends JPanel {
    private static final int SUN_RADIUS = 50;
    private static final int PLANET_RADIUS = 30;
    private static final int ORBIT_RADIUS = 200;
    private static final int ROTATION_COUNT = 365;

    private double planetAngle = 0;

    public Exercise6() {
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
        g2d.setColor(Color.GRAY);
        g2d.fill(new Ellipse2D.Double(ORBIT_RADIUS - SUN_RADIUS, ORBIT_RADIUS - SUN_RADIUS, 2 * SUN_RADIUS, 2 * SUN_RADIUS));

        // planet
        double planetX = ORBIT_RADIUS + ORBIT_RADIUS * Math.cos(planetAngle);
        double planetY = ORBIT_RADIUS - ORBIT_RADIUS * Math.sin(planetAngle); // Minus because y-axis is inverted

        // garis planet
        g2d.setColor(Color.WHITE);
        g2d.draw(new Ellipse2D.Double(0, 0, 2 * ORBIT_RADIUS, 2 * ORBIT_RADIUS));

        // planet
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(new Ellipse2D.Double(planetX - PLANET_RADIUS, planetY - PLANET_RADIUS, 2 * PLANET_RADIUS, 2 * PLANET_RADIUS));

        // point 2d
        double pointX = planetX + PLANET_RADIUS * Math.cos(-planetAngle);
        double pointY = planetY + PLANET_RADIUS * Math.sin(-planetAngle); // Minus because y-axis is inverted
        g2d.setColor(Color.GRAY);
        g2d.fill(new Ellipse2D.Double(pointX - 3, pointY - 3, 6, 6));

        // huruf y(yemima) p(puturuhu)
        Font font = new Font("Arial", Font.PLAIN, 50);
        g2d.setFont(font);
        g2d.setColor(Color.MAGENTA);

        // jarak y&p
        double interX = 0.5 * (pointX + ORBIT_RADIUS);
        double interY = 0.5 * (pointY + ORBIT_RADIUS);

        // y
        String letterY = "Y";
        FontMetrics fm = g2d.getFontMetrics();
        Rectangle2D boundsY = fm.getStringBounds(letterY, g2d);
        double xY = ORBIT_RADIUS - boundsY.getWidth() / 2;
        double yY = ORBIT_RADIUS + boundsY.getHeight() / 2;
        g2d.drawString(letterY, (float) xY, (float) yY);

        // p
        String letterP = "P";
        Rectangle2D boundsP = fm.getStringBounds(letterP, g2d);
        double xP = interX - boundsP.getWidth() / 2;
        double yP = interY + boundsP.getHeight() / 2;
        g2d.drawString(letterP, (float) xP, (float) yP);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise6");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Exercise6 animation = new Exercise6();
        frame.add(animation);
        frame.setSize(2 * ORBIT_RADIUS + 100, 2 * ORBIT_RADIUS + 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
