/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.swing.other;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mnikiforov
 */
public class DrawPanel extends JPanel {

    public DrawPanel() {
    }

    @Override
    public void paint(Graphics g) {
	super.paint(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(new Color(50, 50, 50, 50));
	g2d.fillRect(0, 0, 200, 200);
    }

    public static void main(String[] args) {
	JFrame frame = new JFrame("Hello");
	frame.setSize(500, 500);
	frame.add(new DrawPanel());
	frame.pack();
	frame.setVisible(true);
    }
}
