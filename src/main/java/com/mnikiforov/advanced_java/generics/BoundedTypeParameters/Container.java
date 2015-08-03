package com.mnikiforov.advanced_java.generics.BoundedTypeParameters;

/**
 * Created by SBT-Nikiforov-MO on 03.08.2015.
 */
public class Container<T extends Product> {

    T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
