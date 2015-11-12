/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.graphics.dithertest2;

import com.mnikiforov.util.Constants;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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

    private static String urlServer = "http://127.0.0.1:8888/";
    private static String controlPanelUuid = "75361110-b863-4c40-806e-9dfe11a6a65a";

    public static void main(String[] args) {
        try {
//            String urlStr = urlServer + "downloaddeviceresource?deviceuuid=" + controlPanelUuid
//                    + "&type=CHECK_LOGO&download=true";
//            URL url = new URL(urlStr);
//            BufferedImage sourceImage;
//            try (InputStream is = url.openConnection().getInputStream()) {
//                sourceImage = ImageIO.read(is);
//            }
//            File outputFile1 = new File(Constants.OUT_PATH + "sourceDitherImage.png");
//            ImageIO.write(sourceImage, "png", outputFile1);

            BufferedImage sourceImage = ImageIO.read(DitherTest.class.getResourceAsStream("/data/checkTitlePicture.png"));
            BufferedImage checkTitlePictureDither = sierraLiteDither(
                    scaledImage(sourceImage, 560f / sourceImage.getWidth()));

            File outputFile2 = new File(Constants.OUT_PATH + "targetDitherImage.png");
            ImageIO.write(checkTitlePictureDither, "png", outputFile2);
        } catch (IOException ex) {
            Logger.getLogger(DitherTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DitherTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BufferedImage scaledImage(BufferedImage sourceImage, float scaleCoef) {
        int w = (int) (sourceImage.getWidth() * scaleCoef);
        int h = (int) (sourceImage.getHeight() * scaleCoef);
        BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(scaleCoef, scaleCoef);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        after = scaleOp.filter(sourceImage, after);
        return after;
    }

    public static BufferedImage resizedImage(BufferedImage originalImage, float scaleCoef) {
        int w = (int) (originalImage.getWidth() * scaleCoef);
        int h = (int) (originalImage.getHeight() * scaleCoef);
        BufferedImage resizedImage = new BufferedImage(w, h, originalImage.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, w, h, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        return resizedImage;
    }

    private static final ColorRGB[] palette = new ColorRGB[]{new ColorRGB(0xff000000), new ColorRGB(0xffffffff)};

    public static BufferedImage sierraLiteDither(BufferedImage image) {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        int w = image.getWidth();
        int h = image.getHeight();
        ColorRGB[][] pixel = new ColorRGB[w][h];

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                pixel[x][y] = new ColorRGB(image.getRGB(x, y));
            }
        }

        float weight = 1f / 4;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                ColorRGB oldpixel = pixel[x][y];
                ColorRGB newpixel = findClosestPaletteColor(oldpixel, palette);
                result.setRGB(x, y, newpixel.toRGB());
                ColorRGB quantError = oldpixel.sub(newpixel);
                try {
                    pixel[x + 1][y] = pixel[x + 1][y].add(quantError.mul(2 * weight));
                    pixel[x - 1][y + 1] = pixel[x - 1][y + 1].add(quantError.mul(weight));
                    pixel[x][y + 1] = pixel[x][y + 1].add(quantError.mul(weight));
                } catch (ArrayIndexOutOfBoundsException ex) {
                }
            }
        }

        return result;
    }

    private static ColorRGB findClosestPaletteColor(ColorRGB c, ColorRGB[] palette) {
        ColorRGB closest = palette[0];
        for (ColorRGB n : palette) {
            if (n.diff(c) < closest.diff(c)) {
                closest = n;
            }
        }

        return closest;
    }
}
