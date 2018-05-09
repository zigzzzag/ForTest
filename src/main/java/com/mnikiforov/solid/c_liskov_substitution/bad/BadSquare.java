package com.mnikiforov.solid.c_liskov_substitution.bad;

@SuppressWarnings("all")
public class BadSquare extends BadRectangle {

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}
