package com.mnikiforov.core.swing.action;

import javax.swing.JFrame;
import java.awt.EventQueue;

/**
 * Created by sbt-nikiforov-mo on 28.06.16.
 */
public class MouseFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 200;

    public MouseFrame() {
        add(new MouseComponent());
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MouseFrame();
                frame.setTitle("MouseFrame");
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
