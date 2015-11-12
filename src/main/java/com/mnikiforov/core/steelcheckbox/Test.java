/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.steelcheckbox;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author mnikiforov
 */
public class Test {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setContentPane(panel);

        JCheckBox c = new SteelCheckBox();
        c.setText("Hello");
//	c.setRised(true);
        panel.add(c);

        frame.pack();
        frame.setVisible(true);
    }
}
