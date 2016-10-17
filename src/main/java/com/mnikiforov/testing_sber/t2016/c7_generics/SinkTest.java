package com.mnikiforov.testing_sber.t2016.c7_generics;

import java.util.Collection;

/**
 * Created by Zigzag on 18.10.2016.
 */
public class SinkTest {

    public static void main(String[] args) {
        Sink<Object> s = null;
        Collection<String> cs = null;
        String str1 = writeAll1(cs, s);
        String str2 = writeAll2(cs, s);
//        String str3 = writeAll3(cs, s); //compile error : method writeAll3 in class SinkTest cannot be applied to given types;
//        String str4 = writeAll4(cs, s); //compile error : method writeAll4 in class SinkTest cannot be applied to given types;
    }

    public static <T> T writeAll1(Collection<? extends T> coll, Sink<? super T> snk) {
        return null;
    }

    public static <T> T writeAll2(Collection<T> coll, Sink<? super T> snk) {
        return null;
    }

    public static <T> T writeAll3(Collection<T> coll, Sink<? extends T> snk) {
        return null;
    }

    public static <T> T writeAll4(Collection<T> coll, Sink<T> snk) {
        return null;
    }
}
