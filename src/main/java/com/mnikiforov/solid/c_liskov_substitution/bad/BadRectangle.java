package com.mnikiforov.solid.c_liskov_substitution.bad;

class BadRectangle {

    private int width;
    private int height;

    int area() {
        return width * height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
