/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.dithertest2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author mnikiforov
 */
public class Palette {

    private static Palette instance = null;
    private final TreeSet<ColorComponent> palette = new TreeSet<ColorComponent>(new Comparator<ColorComponent>() {
	@Override
	public int compare(ColorComponent o1, ColorComponent o2) {
	    return o1.toGray() - o2.toGray();
	}
    });
    private boolean lowpallete = false;

    private Palette() {
    }

    public void clear() {
	lowpallete = false;
	palette.clear();
    }

    public void add(ColorComponent c) {
	palette.add(c);
    }

    public List<ColorComponent> getPalette() {
	return new LinkedList(palette);
    }

    public boolean remove(ColorComponent c) {
	return palette.remove(c);
    }

    public int size() {
	return palette.size();
    }

    public static Palette getInstance() {
	if (instance == null) {
	    instance = new Palette();
	}
	return instance;
    }

    public ColorComponent findNearest(ColorComponent c) {

	int cv = (c.getB() + c.getG() + c.getR()) / 3;

	return cv < 96 ? palette.first() : palette.last();
//        
//        
//        if (lowpallete) {
//            c.mul(0.5f);
//        }
//        Iterator<ColorComponent> it = palette.iterator();
//        ColorComponent near = it.next();
//        double diff = near.diff(c);
//        while (it.hasNext()) {
//            ColorComponent next = it.next();
//            if (next.diff(c) < diff) {
//                near = next;
//                diff = near.diff(c);
//            }
//        }
//
//        return near;
    }

    public void initWebPalette() {
	int colors[] = new int[]{0x00, 0x33, 0x66, 0x99, 0xcc, 0xff};
	clear();
	for (int r = 0; r < 6; r++) {
	    for (int g = 0; g < 6; g++) {
		for (int b = 0; b < 6; b++) {
		    add(new ColorComponent(colors[r], colors[g], colors[b]));
		}
	    }
	}
    }

    public void initHumanPalette() {
	int colors[] = new int[]{0x00, 0x22, 0x44, 0x66, 0x88, 0xaa, 0xcc, 0xff};
	clear();
	for (int r = 0; r < 8; r++) {
	    for (int g = 0; g < 8; g++) {
		for (int b = 0; b < 4; b++) {
		    add(new ColorComponent(colors[r], colors[g], colors[b * 2]));
		}
	    }
	}
    }

    public void initDos16ColorsPalette() {
	clear();

	palette.add(new ColorComponent(0x000000));
	palette.add(new ColorComponent(0x0000AA));
	palette.add(new ColorComponent(0x00AA00));
	palette.add(new ColorComponent(0x00AAAA));
	palette.add(new ColorComponent(0xAA0000));
	palette.add(new ColorComponent(0xAA00AA));
	palette.add(new ColorComponent(0xAA5500));
	palette.add(new ColorComponent(0xAAAAAA));
	palette.add(new ColorComponent(0x555555));
	palette.add(new ColorComponent(0x5555FF));
	palette.add(new ColorComponent(0x55FF55));
	palette.add(new ColorComponent(0x55FFFF));
	palette.add(new ColorComponent(0xFF5555));
	palette.add(new ColorComponent(0xFF55FF));
	palette.add(new ColorComponent(0xFFFF55));
	palette.add(new ColorComponent(0xFFFFFF));
    }

    public void initDos8ColorsPalette() {
	clear();
	lowpallete = true;
	palette.add(new ColorComponent(0x000000));
	palette.add(new ColorComponent(0x0000AA));
	palette.add(new ColorComponent(0x00AA00));
	palette.add(new ColorComponent(0x00AAAA));
	palette.add(new ColorComponent(0xAA0000));
	palette.add(new ColorComponent(0xAA00AA));
	palette.add(new ColorComponent(0xAA5500));
	palette.add(new ColorComponent(0xAAAAAA));

    }

    public void initBWPalette() {
	clear();
	palette.add(new ColorComponent(0x000000));
	palette.add(new ColorComponent(0xFFFFFF));
    }

    public void init4ColorPalette() {
	clear();
	palette.add(new ColorComponent(0x000000));
	palette.add(new ColorComponent(0x0000FF));
	palette.add(new ColorComponent(0x00FF00));
	palette.add(new ColorComponent(0xFF0000));
	palette.add(new ColorComponent(0xFFFFFF));
    }

    public void init4BWColorPalette() {
	clear();
	palette.add(new ColorComponent(0x000000));
	palette.add(new ColorComponent(0x666666));
	palette.add(new ColorComponent(0xCCCCCC));
	palette.add(new ColorComponent(0xFFFFFF));
    }

    public void init8BWColorPalette() {
	clear();
	palette.add(new ColorComponent(0x000000));
	palette.add(new ColorComponent(0x222222));
	palette.add(new ColorComponent(0x444444));
	palette.add(new ColorComponent(0x666666));
	palette.add(new ColorComponent(0x888888));
	palette.add(new ColorComponent(0xAAAAAA));
	palette.add(new ColorComponent(0xCCCCCC));
	palette.add(new ColorComponent(0xFFFFFF));
    }

    public void initGrayPalette() {
	clear();
	for (int i = 0; i < 256; i++) {
	    palette.add(new ColorComponent(i, i, i));
	}
    }

    public void init64GrayPalette() {
	clear();
	for (int i = 0; i < 64; i++) {
	    palette.add(new ColorComponent(i * 4 - 1, i * 4 - 1, i * 4 - 1));
	}
    }

    public void init16GrayPalette() {
	clear();
	for (int i = 0; i < 16; i++) {
	    palette.add(new ColorComponent(i * 16, i * 16, i * 16));
	}
    }

    public void initCMYKPalette() {
	clear();

	final int step = 128;
	for (int c = 0; c <= 256; c += step) {
	    for (int m = 0; m <= 256; m += step) {
		for (int y = 0; y <= 256; y += step) {
		    for (int k = 0; k <= 256; k += step) {

			int r = ((256 - c) / (256 - k + 1)) - 1;
			int g = ((256 - m) / (256 - k + 1)) - 1;
			int b = ((256 - y) / (256 - k + 1)) - 1;
			r = r < 0 ? 0 : r;
			g = g < 0 ? 0 : g;
			b = b < 0 ? 0 : b;
			r = r > 255 ? 255 : r;
			g = g > 255 ? 255 : g;
			b = b > 255 ? 255 : b;

			ColorComponent pal = new ColorComponent(r, g, b);

			if (!palette.contains(pal)) {
			    //System.out.println(r + " " + g + " " + b);
			    add(pal);
			}
		    }
		}
	    }
	}

    }
}
