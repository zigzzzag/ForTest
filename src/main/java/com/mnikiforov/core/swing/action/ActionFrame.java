package com.mnikiforov.core.swing.action;

import com.mnikiforov.util.Constants;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

/**
 * Фрейм с панелью для демонстрации действий по изменению цвета
 * <p>
 * Created by zigzzzag on 27.06.16.
 */
public class ActionFrame extends JFrame {

    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 200;

    public ActionFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        buttonPanel = new JPanel();

        Action yellowAction = new ColorAction("Yellow", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
        Action blueAction = new ColorAction("Blue", new ImageIcon(Constants.DATA_PATH + "earth.gif"), Color.BLUE);
        Action redAction = new ColorAction("Red", new ImageIcon("red-ball.gif"), Color.RED);

        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        add(buttonPanel);

        // привязать клавиши <Y>, <B>, <R> к надписям на кнопках
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

        // привязать надписи на кнопках панели к действиям
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);
    }

    public class ColorAction extends AbstractAction {

        public ColorAction(String name, Icon icon, Color c) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
            putValue("color", c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ActionFrame();
                frame.setTitle("ActionFrame");
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
