package com.mnikiforov.core.overloading;

/**
 * Created by sbt-nikiforov-mo on 15.02.16.
 */
public class OverloadByReturnType {

    Object f() {
        return null;
    }

//Ошибка компиляции - нельзя перегружать методы по возвращаемому типу
//    String f() {
//        return null;
//    }
}
