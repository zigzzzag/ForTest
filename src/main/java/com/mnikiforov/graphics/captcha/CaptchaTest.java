/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.graphics.captcha;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author mnikiforov
 */
public class CaptchaTest {

    public static void main(String[] args) throws IOException {
        BufferedImage image = responseCaptcha("714EF");
        ImageIO.write(image, "PNG", new File("out/captcha.png"));
    }

    private static BufferedImage responseCaptcha(String captcha) throws IOException {
        BufferedImage image = new BufferedImage(200, 60, BufferedImage.TYPE_BYTE_INDEXED);

        Graphics2D gr = image.createGraphics();

        gr.setColor(Color.WHITE);
        gr.fillRect(0, 0, image.getWidth(), image.getHeight());
        gr.setColor(Color.BLACK);
        gr.drawRect(0, 0, image.getWidth() - 1, image.getHeight() - 1);

        gr.setFont(Font.decode("Arial-bold-58"));
        for (int i = 0; i < captcha.length(); i++) {
            gr.setColor(Color.BLACK);
            gr.drawString(captcha.substring(i, i + 1), i * 40 + 3, 50);
            gr.setColor(Color.WHITE);
            gr.drawString(captcha.substring(i, i + 1), i * 40 + 1, 50 + 2);
        }

//	ImageIO.write(image, "PNG", out);
        return image;
    }
}
