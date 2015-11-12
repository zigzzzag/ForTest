/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.graphics.dithertest2;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mnikiforov
 */
public class PrinterFactory {

    private static final Logger log = LoggerFactory.getLogger(PrinterFactory.class);
    private static final int matrixShiftX = 2;
    private static final int matrixShiftY = 0;
    private static final float[][] matrix = new float[][]{
	{-1, -1, 0, 5f / 32f, 3f / 32f},
	{2f / 32f, 3f / 32f, 4f / 32f, 3f / 32f, 2f / 32f},
	{-1, 2f / 32f, 3f / 32f, 2f / 32f, -1}
    };

    private PrinterFactory() {
    }

    public static PrinterDriverInterface getPrinter(Class clazz) throws InstantiationException, IllegalAccessException {
	return (PrinterDriverInterface) clazz.newInstance();
    }

    public static BufferedImage getDitheredImage(BufferedImage image) throws Exception {
	Palette palette = Palette.getInstance();
	palette.initBWPalette();

	float scaleW = 560f;
	image = scaledImage(image, scaleW / image.getWidth());

	BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

	log.info("Create dither error matrix ...");
	ColorComponent[][] ditherSrc = new ColorComponent[image.getWidth()][image.getHeight()];
	for (int y = 0; y < ditherSrc[0].length; y++) {
	    for (int x = 0; x < ditherSrc.length; x++) {
		ditherSrc[x][y] = new ColorComponent(image.getRGB(x, y));
	    }
	}

	log.info("Dither");
	for (int y = 0; y < ditherSrc[0].length; y++) {
	    for (int x = 0; x < ditherSrc.length; x++) {
		ColorComponent oldcolor = ditherSrc[x][y];
		ColorComponent newcolor = palette.findNearest(oldcolor);
		ColorComponent error = new ColorComponent(oldcolor.toRGB());
		error.sub(newcolor);
		for (int sy = -matrixShiftY; sy < matrix.length - matrixShiftY; sy++) {
		    for (int sx = -matrixShiftX; sx < matrix[sy + matrixShiftY].length - matrixShiftX; sx++) {
			if (checkBounds(ditherSrc, x + sx, y + sy)) {
			    float val = matrix[sy + matrixShiftY][sx + matrixShiftX];
			    if (val == 0) {
				result.setRGB(x + sx, y + sy, newcolor.toRGB());
				ditherSrc[x + sx][y + sy] = newcolor;
			    } else if (val > 0) {
				ColorComponent dif = (ColorComponent) error.clone();
				dif.mul(val);
				ditherSrc[x + sx][y + sy].add(dif);
			    }
			}
		    }
		}
	    }
	}

	return result;
    }

    private static boolean checkBounds(ColorComponent[][] ditherSrc, int x, int y) {
	return x >= 0 && y >= 0 && x < ditherSrc.length && y < ditherSrc[0].length;
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
}
