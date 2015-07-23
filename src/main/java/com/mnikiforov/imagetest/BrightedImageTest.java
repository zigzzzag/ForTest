/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.imagetest;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author mnikiforov
 */
public class BrightedImageTest {

        float brightenFactor = 1.2f;

        private BufferedImage createBrightImage(BufferedImage image) {
                RescaleOp op = new RescaleOp(brightenFactor, 0, null);

                BufferedImage resultImage = op.filter(image, image);

                return resultImage;
        }

        public static void main(String[] args) throws IOException {
                BrightedImageTest brightedImageTest = new BrightedImageTest();

                BufferedImage sourceImage = ImageIO.read(new File("serviceButtonImage.jpg"));

                BufferedImage resultImage = brightedImageTest.createBrightImage(sourceImage);

                ImageIO.write(resultImage, "png", new File("BrightedImageTest.png"));
        }
}
