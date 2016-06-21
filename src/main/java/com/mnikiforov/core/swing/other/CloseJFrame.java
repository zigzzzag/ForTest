/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.swing.other;

import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mnikiforov
 */
public class CloseJFrame extends JFrame {

    public CloseJFrame(String title) throws HeadlessException {
	super(title);

	addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowClosing(WindowEvent e) {
//			closeClient();
		int response = JOptionPane.showConfirmDialog(CloseJFrame.this, "Завершить прием?", "Сообщение",
			JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.OK_OPTION) {
//			closeClient();
		    CloseJFrame.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	    }
	});
    }

    public static void main(String[] args) {
	JFrame frame = new CloseJFrame("test");
	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	frame.setVisible(true);
    }
}
