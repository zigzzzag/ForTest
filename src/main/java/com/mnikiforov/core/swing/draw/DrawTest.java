package com.mnikiforov.core.swing.draw;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by sbt-nikiforov-mo on 21.06.16.
 */
public class DrawTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new DrawFrame();
                frame.setTitle("DrawTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //fix for ubuntu with two monitors (http://stackoverflow.com/questions/18080612/swing-application-wont-display-in-unity-when-second-monitor-is-on-the-left)
                //setLocation copes just fine with the multiple monitors. It's just that the default location (if setLocation is not called) appears to be off screen when monitor 2 is left.
                //0,0 is at the top left on the left monitor as expected. However if you use setLocation(0,0) the window's close / minimize / maximize buttons are obscured by the unity top bar.
                //I guess some platform-specific stuff is required to integrate with the unity top bar / side bar.
                frame.setLocation(50, 50);

                frame.setVisible(true);
            }
        });
    }
}

class DrawFrame extends JFrame {

    public DrawFrame() {
        add(new DrawComponent());
        pack();
    }
}

class DrawComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //нарисовать прямоугольник
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.draw(rect);

        //нарисовать вписанный эллипс
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        //Нарисовать диагональную линию
        g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

        //нарисовать окружность с тем же самым центром
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;
        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.draw(circle);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}