package com.mnikiforov.solid.a_single_responsibility.bad;

import java.util.UUID;

@SuppressWarnings("JavaDoc")
public class BadGeometricFigure {

    private final String uuid = UUID.randomUUID().toString();
    private int width = -1;
    private int height = -1;
    private int radius = -1;

    /**
     * Rectangle
     *
     * @param width
     * @param height
     */
    BadGeometricFigure(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Circle
     *
     * @param radius
     */
    BadGeometricFigure(int radius) {
        this.radius = radius;
    }

    double area() {
        if (radius == -1) {
            return (double) width * height;
        } else {
            return Math.PI * radius * radius;
        }
    }

    public String draw() {
        if (radius == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("--draw rectangle (width, height)=(").append(width).append(",").append(height).append(")")
                    .append("\r\n");

            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    sb.append("*");
                }
                sb.append("\r\n");
            }
            return sb.toString();
        } else {
            return "This is circle draw!!! radius = " + radius;
        }
    }

    String getUuid() {
        return uuid;
    }
}
