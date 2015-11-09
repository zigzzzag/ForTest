/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.dithertest;

import com.mnikiforov.util.Constants;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * @author mnikiforov
 */
public class DitherTest {

    public static void main(String[] args) {
        try {
            BufferedImage sourceImage = ImageIO.read(DitherTest.class.getResourceAsStream("/data/checkTitlePicture.png"));
            BufferedImage checkTitlePictureDither = PrinterFactory.getDitheredImage(sourceImage);

            File outputFile1 = new File(Constants.OUT_PATH + "sourceDitherImage.png");
            ImageIO.write(sourceImage, "png", outputFile1);

            File outputFile2 = new File(Constants.OUT_PATH + "targetDitherImage.png");
            ImageIO.write(checkTitlePictureDither, "png", outputFile2);
        } catch (IOException ex) {
            Logger.getLogger(DitherTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DitherTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
