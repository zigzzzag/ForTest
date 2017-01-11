package com.mnikiforov.core.swing.mask;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

/**
 * Created by zigzzzag on 12/12/16.
 */
public class MaskInputSample2 {
    public static void main(String args[]) {

        JFrame frame = new JFrame("Mask Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 200);

        //fix for ubuntu with two monitors (http://stackoverflow.com/questions/18080612/swing-application-wont-display-in-unity-when-second-monitor-is-on-the-left)
        //setLocation copes just fine with the multiple monitors. It's just that the default location (if setLocation is not called) appears to be off screen when monitor 2 is left.
        //0,0 is at the top left on the left monitor as expected. However if you use setLocation(0,0) the window's close / minimize / maximize buttons are obscured by the unity top bar.
        //I guess some platform-specific stuff is required to integrate with the unity top bar / side bar.
        frame.setLocation(50, 50);


        BoxLayout layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(layout);

        try {
            JLabel label = new JLabel("SSN");

            MaskFormatter formatter = new MaskFormatter("'(###')' ###'-####");
            formatter.setPlaceholderCharacter('_');
            formatter.setCommitsOnValidEdit(false);
            formatter.setValueContainsLiteralCharacters(false);

            final JFormattedTextField input = new JFormattedTextField(formatter);
//            input.setValue("(123) 145-6789");
//            input.setValue("1231456789");
//            input.setColumns(20);

            JPanel panel = new JPanel();
            panel.add(label);
            panel.add(input);

            final JLabel lgt = new JLabel("getText():");
            panel.add(lgt);
            final JLabel gt = new JLabel("GOGI");
            panel.add(gt);

            final JLabel lgv = new JLabel("getValue():");
            panel.add(lgv);
            final JLabel gv = new JLabel("GOGI");
            panel.add(gv);

            input.getDocument().addDocumentListener(new DocumentListener() {
                private void notice() {
                    gt.setText(input.getText());
                    gv.setText((String) input.getValue());
                }

                @Override
                public void insertUpdate(DocumentEvent e) {
                    notice();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    notice();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    notice();
                }
            });

            JButton b = new JButton("UPDATE");
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("UPDATE");
                    gt.setText(input.getText());
                    gv.setText((String) input.getValue());
                }
            });
            panel.add(b);

            frame.add(panel);
        } catch (ParseException e) {
            System.err.println("Unable to add SSN");
        }

        frame.setVisible(true);
    }


}
