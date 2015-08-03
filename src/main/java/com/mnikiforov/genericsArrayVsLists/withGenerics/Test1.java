package com.mnikiforov.genericsArrayVsLists.withGenerics;

import java.util.List;

/**
 * Created by SBT-Nikiforov-MO on 23.04.2015.
 */
public class Test1 {

    //наивная реализация метода reduce с дженериками. Небезопасно (E[]) list.toArray(). Малейшее изменение и будет ClassCastException!
    static <E> E reduce(List<E> list, Function<E> f, E initValue) {
        E[] snapshot = (E[]) list.toArray();
        E result = initValue;
        for (E e : snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }
}
