/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.imagetest;

import com.mnikiforov.util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.io.File;
import java.io.IOException;

/**
 * @author mnikiforov
 */
public class RescalingICMExample {

    public static void main(String[] args) throws IOException {
//                URL url = new URL("http://weblogs.java.net/jag/bio/JagHeadshot-small.jpg");
        BufferedImage original = ImageIO.read(new File(Constants.DATA_PATH + "greenbutton.png"));
        BufferedImage index = convertType(original, BufferedImage.TYPE_BYTE_INDEXED);

        JPanel p = new JPanel(new GridLayout(2, 4));
        addToPanel(p, original, "original image");
        addToPanel(p, index, "indexed version");

        float[] scales = {1f, 1.1f, 1.2f, 1.3f, 1.3f, 1.3f};
        float[] offsets = {48, 32, 16, 0, 16, 32};
        for (int i = 0; i < scales.length; ++i) {
            float s = scales[i];
            float o = offsets[i];
            addToPanel(p, rescale(index, s, o), "scale=" + s + ", offset=" + o);
        }

        JFrame f = new JFrame("");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(p);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static BufferedImage convertType(BufferedImage image, int type) {
        if (image.getType() == type) {
            return image;
        }
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), type);
        Graphics2D g = result.createGraphics();
        g.drawRenderedImage(image, null);
        g.dispose();

        return result;
    }

    static void addToPanel(JPanel p, BufferedImage image, String title) {
        JLabel label = new JLabel(new ImageIcon(image));
        label.setBorder(BorderFactory.createTitledBorder(title));
        p.add(label);
    }

    public static IndexColorModel rescale(IndexColorModel icm, float scaleFactor, float offset) {
        int size = icm.getMapSize();
        byte[] reds = new byte[size], greens = new byte[size], blues = new byte[size], alphas = new byte[size];
        icm.getReds(reds);
        icm.getGreens(greens);
        icm.getBlues(blues);
        icm.getAlphas(alphas);

        rescale(reds, scaleFactor, offset);
        rescale(greens, scaleFactor, offset);
        rescale(blues, scaleFactor, offset);

        return new IndexColorModel(8, size, reds, greens, blues, alphas);
    }

    public static void rescale(byte[] comps, float scaleFactor, float offset) {
        for (int i = 0; i < comps.length; ++i) {
            int comp = 0xff & comps[i];
            int newComp = Math.round(comp * scaleFactor + offset);
            if (newComp < 0) {
                newComp = 0;
            } else if (newComp > 255) {
                newComp = 255;
            }
            comps[i] = (byte) newComp;
        }
    }

    public static BufferedImage rescale(BufferedImage indexed, float scaleFactor, float offset) {
        IndexColorModel icm = (IndexColorModel) indexed.getColorModel();
        return new BufferedImage(rescale(icm, scaleFactor, offset), indexed.getRaster(), false, null);
    }
}
