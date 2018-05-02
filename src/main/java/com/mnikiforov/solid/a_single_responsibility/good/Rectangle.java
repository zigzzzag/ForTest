package com.mnikiforov.solid.a_single_responsibility.good;

public class Rectangle extends GoodFigure {

    private final int width;
    private final int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return (double) width * height;
    }

    @Override
    public String draw() {
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
    }
}
