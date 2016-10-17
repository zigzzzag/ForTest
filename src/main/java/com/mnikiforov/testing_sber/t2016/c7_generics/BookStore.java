package com.mnikiforov.testing_sber.t2016.c7_generics;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Zigzag on 18.10.2016.
 */
public class BookStore {
    Map<Book, Integer> map = new TreeMap<>();

    public BookStore() {
        map.put(new Book("asd"), new Integer(10));
    }

    public int getNumberOfCopies(Book b) {
        Integer i = (Integer) map.get(b);
        return i == null ? 0 : i.intValue();
    }
}
