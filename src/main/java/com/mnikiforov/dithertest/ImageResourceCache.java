/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.dithertest;

import static com.mnikiforov.dithertest.Constants.receiptWidth;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mnikiforov
 */
public class ImageResourceCache {

    private static ImageResourceCache instance = null;
    private LinkedHashMap<String, BufferedImage> imageList = new LinkedHashMap<String, BufferedImage>();
    private static final Logger log = LoggerFactory.getLogger(ImageResourceCache.class);

    private ImageResourceCache() {
    }

    public static ImageResourceCache getInstance() {
	if (instance == null) {
	    instance = new ImageResourceCache();
	}
	return instance;
    }

    public BufferedImage getResourceImage(String fileName) throws IOException {

	String sf = fileName.toUpperCase();

	if (imageList.containsKey(sf)) {
	    return imageList.get(sf);
	}
	imageList.put(sf, ImageIO.read(getClass().getResourceAsStream("/" + fileName)));

	return imageList.get(sf);
    }

    public void cashedImage(BufferedImage image, String fileName) {
	String sf = fileName.toUpperCase();

	if (!imageList.containsKey(sf)) {
	    imageList.put(sf, image);
	    log.info("image {} was cashed", fileName);
	}
    }
}
