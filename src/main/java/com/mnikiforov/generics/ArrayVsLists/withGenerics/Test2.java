package com.mnikiforov.generics.ArrayVsLists.withGenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SBT-Nikiforov-MO on 23.04.2015.
 */
public class Test2 {

    //реализация метода reduce с дженериками
    static <E> E reduce(List<E> list, Function<E> f, E initValue) {
        List<E> snapshot;
        synchronized (list) {
            snapshot = new ArrayList<E>(list);
        }

        E result = initValue;
        for (E e : snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }
}
