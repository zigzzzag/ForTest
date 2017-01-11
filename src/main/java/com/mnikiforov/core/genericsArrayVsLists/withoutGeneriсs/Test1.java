package com.mnikiforov.core.genericsArrayVsLists.withoutGeneriсs;

import java.util.List;

/**
 * Created by zigzzzag on 23.04.2015.
 */
public class Test1 {

    //реализация метода reduce без дженериков и с недостатками параллелизма
    static Object reduce(List list, Function f, Object initValue) {
        Object result = initValue;
        for (Object o : list) {
            result = f.apply(result, o);
        }
        return result;
    }
}
