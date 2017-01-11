package com.mnikiforov.core.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by zigzzzag on 14.06.16.
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

        StringBuilder resultBuilder = new StringBuilder();
        if (clazz.isArray()) {
            resultBuilder.append(clazz.getComponentType()).append("[]{");
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) resultBuilder.append(",");
                Object val = Array.get(obj, i);
                if (clazz.getComponentType().isPrimitive()) {
                    resultBuilder.append(val);
                } else {
                    resultBuilder.append(toString(val));
                }
            }
            resultBuilder.append("}");
            return resultBuilder.toString();
        }

        resultBuilder.append(clazz.getName());
        do {
            resultBuilder.append("[");
            Field[] fields = clazz.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);

            int countNonStaticFields = 0;
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (countNonStaticFields > 0) {
                        resultBuilder.append(",");
                    }
                    countNonStaticFields++;

                    resultBuilder.append(f.getName()).append("=");
                    try {
                        Class type = f.getType();
                        Object val = f.get(obj);
                        if (type.isPrimitive()) {
                            resultBuilder.append(val);
                        } else {
                            resultBuilder.append(toString(val));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            resultBuilder.append("]");
            clazz = clazz.getSuperclass();
        } while (clazz != null);

        return resultBuilder.toString();
    }

    public static void main(String[] args) {
//        int[] testArr = new int[5];
//        for (int i = 0; i < 5; i++) {
//            testArr[i] = i * i;
//        }
//        System.out.println(ObjectAnalyzer.toString(testArr));

        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i < 5; i++) squares.add(i * i);

        System.out.println(ObjectAnalyzer.toString(squares));
    }
}
