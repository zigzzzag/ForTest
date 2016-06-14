package com.mnikiforov.core.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by sbt-nikiforov-mo on 14.06.16.
 */
public class ObjectAnalyzer {

    private static ArrayList<Object> visited = new ArrayList<>();

    /**
     * Преобразует объект в строковое представление всех перечисляемых полей
     *
     * @param obj Объект
     * @return Возвращает строку с именем класса и всеми полями объекта, а также их значениями
     */
    public static String toString(Object obj) {
        if (obj == null) return "null";

        if (visited.contains(obj)) return "...";
        visited.add(obj);

        Class clazz = obj.getClass();
        if (clazz == String.class) return (String) obj;

        if (clazz.isArray()) {
            String result = clazz.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) result += ",";
                Object val = Array.get(obj, i);
                if (clazz.getComponentType().isPrimitive()) {
                    result += val;
                } else {
                    result += toString(val);
                }
            }
            return result + "}";
        }

        String result = clazz.getName();
        do {
            result += "[";
            Field[] fields = clazz.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);

            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (i > 0) {
                        result += ",";
                    }
                    result += f.getName() + "=";
                    try {
                        Class type = f.getType();
                        Object val = f.get(obj);
                        if (type.isPrimitive()) {
                            result += val;
                        } else {
                            result += toString(val);
                        }
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
//        int[] testArr = new int[5];
//        for (int i = 0; i < 5; i++) {
//            testArr[i] = i * i;
//        }
//        System.out.println(ObjectAnalyzer.toString(testArr));

        ArrayList<Integer> squares = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) squares.add(i * i);

        //TODO find bug
        System.out.println(ObjectAnalyzer.toString(squares));
    }
}
