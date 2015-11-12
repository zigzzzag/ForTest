package com.mnikiforov.graphics.dithertest2;

import java.awt.Color;

/**
 *
 * @author mnikiforov
 */
public class ColorRGB {

    int r, g, b;

    public ColorRGB(int c) {
	Color color = new Color(c);
	this.r = color.getRed();
	this.g = color.getGreen();
	this.b = color.getBlue();
    }

    public ColorRGB(int r, int g, int b) {
	this.r = r;
	this.g = g;
	this.b = b;
    }

    public ColorRGB add(ColorRGB o) {
	return new ColorRGB(r + o.r, g + o.g, b + o.b);
    }

    public ColorRGB sub(ColorRGB o) {
	return new ColorRGB(r - o.r, g - o.g, b - o.b);
    }

    public ColorRGB mul(float d) {
	return new ColorRGB((int) (d * r), (int) (d * g), (int) (d * b));
    }

    public int diff(ColorRGB o) {
	int Rdiff = o.r - this.r;
	int Gdiff = o.g - this.g;
	int Bdiff = o.b - this.b;
	int distanceSquared = Rdiff * Rdiff + Gdiff * Gdiff + Bdiff * Bdiff;
	return distanceSquared;
    }

    public int toRGB() {
	return toColor().getRGB();
    }

    public Color toColor() {
	return new Color(clamp(r), clamp(g), clamp(b));
    }

    public int clamp(int c) {
	return Math.max(0, Math.min(255, c));
    }

    public ColorRGB getMeanColor(ColorRGB color) {
	return new ColorRGB((r + color.r) / 2, (g + color.g) / 2, (b + color.b) / 2);
    }

    public int getMeanPixel() {
	return (r + g + b) / 3;
    }
}
