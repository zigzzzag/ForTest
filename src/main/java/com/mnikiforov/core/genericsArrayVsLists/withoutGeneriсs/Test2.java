package com.mnikiforov.core.genericsArrayVsLists.withoutGeneriсs;

import java.util.List;

/**
 * Created by SBT-Nikiforov-MO on 23.04.2015.
 */
public class Test2 {

    //реализация метода reduce без дженериков и недостатков параллелизма
    static Object reduce(List list, Function f, Object initValue) {
        Object[] snapshot = list.toArray();
        Object result = initValue;
        for (Object o : snapshot) {
            result = f.apply(result, o);
        }
        return result;
    }
}
