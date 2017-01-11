package com.mnikiforov.core.swing.action;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zigzzzag on 22.06.16.
 */
public class SimpleActionFrame extends JFrame {

    private final JPanel buttonPanel = new JPanel();
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleActionFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        add(buttonPanel);

        initColorButtons();

        initLookAndFeelButtons();

        pack();
    }

    private void initLookAndFeelButtons() {
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (final UIManager.LookAndFeelInfo info : infos) {
            JButton button = new JButton(info.getName());
            buttonPanel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        UIManager.setLookAndFeel(info.getClassName());
                        SwingUtilities.updateComponentTreeUI(SimpleActionFrame.this);
                        pack();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
    }

    private void initColorButtons() {
        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");

        yellowButton.addActionListener(new ColorAction(Color.YELLOW));
        blueButton.addActionListener(new ColorAction(Color.BLUE));
        redButton.addActionListener(new ColorAction(Color.RED));

        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
    }

    private class ColorAction implements ActionListener {

        private Color backgroundColor;

        public ColorAction(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground(backgroundColor);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new SimpleActionFrame();
                frame.setTitle("SimpleActionFrame");
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
