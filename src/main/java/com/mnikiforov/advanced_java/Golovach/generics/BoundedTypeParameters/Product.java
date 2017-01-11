package com.mnikiforov.advanced_java.Golovach.generics.BoundedTypeParameters;

/**
 * Created by zigzzzag on 03.08.2015.
 */
public abstract class Product<T extends Product<T>> implements Comparable<T> {

    private String name;
    private float cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }

    abstract void subCompare(T product);
}
