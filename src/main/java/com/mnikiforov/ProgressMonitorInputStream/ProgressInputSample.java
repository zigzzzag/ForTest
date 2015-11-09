/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.ProgressMonitorInputStream;

import com.mnikiforov.util.Constants;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ProgressMonitorInputStream;

public class ProgressInputSample {

    public static final int NORMAL = 0;

    public static void main(String args[]) throws Exception {
        int returnValue = NORMAL;

        JFrame frame = new JFrame("111");
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setSize(200, 200);
        frame.setContentPane(panel);

        FileInputStream fis = new FileInputStream("pom.xml");
        JLabel filenameLabel = new JLabel(Constants.DATA_PATH + "sourceDitherImage.png", JLabel.RIGHT);
        filenameLabel.setForeground(Color.black);
        Object message[] = {"Reading:", filenameLabel};
        ProgressMonitorInputStream pmis = new ProgressMonitorInputStream(panel, message, fis);
        InputStreamReader isr = new InputStreamReader(pmis);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            Thread.sleep(500);
        }
        br.close();
        // AWT Thread created - must exit
        System.exit(returnValue);
    }
}
