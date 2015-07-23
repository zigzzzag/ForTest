/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.dithertest;

/**
 *
 * @author mnikiforov
 */
public class ColorComponent {

    private int r;
    private int g;
    private int b;

    public ColorComponent(int r, int g, int b) {
	this.r = r;
	this.g = g;
	this.b = b;
    }

    public ColorComponent(int rgb) {
	this.r = (rgb >> 16) & 0xFF;
	this.g = (rgb >> 8) & 0xFF;
	this.b = (rgb) & 0xFF;
    }

    public void mul(float f) {
	r *= f;
	g *= f;
	b *= f;
    }

    public void div(float f) {
	r /= f;
	g /= f;
	b /= f;
    }

    public void add(int rgb) {
	this.r += (rgb >> 16) & 0xFF;
	this.g += (rgb >> 8) & 0xFF;
	this.b += (rgb) & 0xFF;
    }

    public void add(int rc, int gc, int bc) {
	this.r += rc;
	this.g += gc;
	this.b += bc;
    }

    public void add(ColorComponent crgb) {
	this.r += crgb.r;
	this.g += crgb.g;
	this.b += crgb.b;
    }

    public void sub(int rgb) {
	this.r -= (rgb >> 16) & 0xFF;
	this.g -= (rgb >> 8) & 0xFF;
	this.b -= (rgb) & 0xFF;
    }

    public void sub(int rc, int gc, int bc) {
	this.r -= rc;
	this.g -= gc;
	this.b -= bc;
    }

    public void sub(ColorComponent crgb) {
	this.r -= crgb.r;
	this.g -= crgb.g;
	this.b -= crgb.b;
    }

    private int strip(int c) {
	return Math.max(0, Math.min(255, c));
    }

    public double diff(int rc, int gc, int bc) {

	double rmean = (r + rc) / 2.0;

	int rv = r - rc;
	int gv = g - gc;
	int bv = b - bc;

	double rm = 2.0d + rmean / 256d;
	double gm = 4.0;
	double bm = 2.0d + (256d - rmean) / 256d;

	return sqrt((float) (rv * rm * rm + gv * gm * gm + bv * bm * bm));
    }

    private static float sqrt(float number) {

	int i;
	float x2, y;
	float threehalfs = 1.5F;

	x2 = number * 0.5F;
	y = number;
	i = Float.floatToRawIntBits(y);

	i = 0x5f3759df - (i >> 1);
	y = Float.intBitsToFloat(i);
	y = y * (threehalfs - (x2 * y * y));

	return 1f / y;

    }

    public double diff(int rgb) {
	double rmean = (r + ((rgb >> 16) & 0xFF)) / 2.0;

	int rv = r - ((rgb >> 16) & 0xFF);
	int gv = g - ((rgb >> 8) & 0xFF);
	int bv = b - ((rgb) & 0xFF);

	double rm = 2.0d + rmean / 256d;
	double gm = 4.0;
	double bm = 2.0d + (256d - rmean) / 256d;

	return sqrt((float) (rv * rm * rm + gv * gm * gm + bv * bm * bm));

    }

    public double diff(ColorComponent crgb) {
	double rmean = (r + crgb.r) / 2.0;

	int rv = r - crgb.r;
	int gv = g - crgb.g;
	int bv = b - crgb.b;

//        double rm = 2.0d + rmean / 256d;
//        double gm = 4.0;
//        double bm = 2.0d + (256d - rmean) / 256d;
	return sqrt(rv * rv + gv * gv + bv * bv);
    }

    public int toRGB() {
	return (strip(r) << 16) + (strip(g) << 8) + strip(b);
    }

    public int toGray() {
	int newRed = (int) (0.2989f * r);
	int newGreen = (int) (0.5870f * g);
	int newBlue = (int) (0.1140f * b);
	return (newRed + newGreen + newBlue);
    }

    @Override
    public int hashCode() {
	return toRGB();
    }

    public int getB() {
	return b;
    }

    public int getG() {
	return g;
    }

    public int getR() {
	return r;
    }

    @Override
    public boolean equals(Object obj) {
	ColorComponent c = (ColorComponent) obj;
	return r == c.r && g == c.g && b == c.b;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
	return new ColorComponent(r, g, b);
    }

    @Override
    public String toString() {
	return toRGB() + "";
    }
}
