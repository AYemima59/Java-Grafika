import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Exercise5 extends JPanel {
    private int xPosition1 = 0;
    private int yPosition1 = 50;
    private int deltaX1 = 2;

    private int xPosition2 = 0;
    private int yPosition2 = 150;
    private int deltaX2 = 3;

    public Exercise5() {
        Timer timer1 = new Timer(10, e -> {
            xPosition1 += deltaX1;
            if (xPosition1 >= getWidth() || xPosition1 <= 0) {
                deltaX1 = -deltaX1;
            }
            repaint();
        });
        timer1.start();

        Timer timer2 = new Timer(10, e -> {
            xPosition2 += deltaX2;
            if (xPosition2 >= getWidth() || xPosition2 <= 0) {
                deltaX2 = -deltaX2;
            }
            repaint();
        });
        timer2.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the lines
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, yPosition1, getWidth(), yPosition1);
        g2d.drawLine(0, yPosition2, getWidth(), yPosition2);

        // Draw the heartbeats
        drawHeartbeat(g2d, xPosition1, yPosition1);
        drawHeartbeat(g2d, xPosition2, yPosition2);

        g2d.dispose();
    }

    private void drawHeartbeat(Graphics2D g2d, int xPosition, int yPosition) {
        int[] xPoints = {xPosition, xPosition + 10, xPosition + 20, xPosition + 30, xPosition + 40, xPosition + 50, xPosition + 60, xPosition + 70, xPosition + 80, xPosition + 90, xPosition + 100};
        int[] yPoints = {yPosition, yPosition - 10, yPosition + 10, yPosition - 10, yPosition + 10, yPosition - 10, yPosition + 10, yPosition - 10, yPosition + 10, yPosition - 10, yPosition};
        g2d.setColor(Color.RED);
        g2d.drawPolyline(xPoints, yPoints, xPoints.length);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 5: Heartbeat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Exercise5 exercise5 = new Exercise5();
        frame.add(exercise5);
        frame.setSize(600, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
