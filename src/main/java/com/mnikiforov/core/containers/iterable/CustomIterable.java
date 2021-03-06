package com.mnikiforov.core.containers.iterable;

import java.util.Iterator;

/**
 * Created by zigzzzag on 01.03.16.
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

    public Iterable<T> reversed() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private int cursor = elements.length - 1;

                    @Override
                    public boolean hasNext() {
                        return cursor >= 0;
                    }

                    @Override
                    public T next() {
                        return elements[cursor--];
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
