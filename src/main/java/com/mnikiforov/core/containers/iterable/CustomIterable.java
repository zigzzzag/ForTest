package com.mnikiforov.core.containers.iterable;

import java.util.Iterator;

/**
 * Created by sbt-nikiforov-mo on 01.03.16.
 */
public class CustomIterable<T> implements Iterable<T> {

    private T[] elements;

    public CustomIterable(T... elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < elements.length;
            }

            @Override
            public T next() {
                return elements[cursor++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
