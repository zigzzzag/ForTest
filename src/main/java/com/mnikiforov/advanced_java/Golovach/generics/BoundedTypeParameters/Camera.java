package com.mnikiforov.advanced_java.Golovach.generics.BoundedTypeParameters;

/**
 * Created by zigzzzag on 03.08.2015.
 */
public class Camera extends Product<Camera> {

    private int pixel;

    public int getPixel() {
        return pixel;
    }

    public void setPixel(int pixel) {
        this.pixel = pixel;
    }

    @Override
    void subCompare(Camera camera) {
        //todo something
    }
}
