package com.mnikiforov.core.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by sbt-nikiforov-mo on 14.06.16.
 */
public class ObjectAnalyzer {

    /**
     * Преобразует объект в строковое представление всех перечисляемых полей
     *
     * @param obj Объект
     * @return Возвращает строку с именем класса и всеми полями объекта, а также их значениями
     */
    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }

        //TODO remake
        return null;
    }

    @Deprecated
    public static String objectToString(Object obj) {
        Class clazz = obj.getClass();

        //TODO remake on StringBuilder
        String result = clazz.getName();
        do {
            result += "[";
            Field[] fields = clazz.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);

            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!result.endsWith("[")) {
                        result += ",";
                    }
                    result += f.getName() + "=";
                    try {
                        Object val = f.get(obj);
                        result += toString(val);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            result += "]";
            clazz = clazz.getSuperclass();
        } while (clazz != null);

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            squares.add(i * i);
        }

        System.out.println(ObjectAnalyzer.objectToString(squares));
    }
}
