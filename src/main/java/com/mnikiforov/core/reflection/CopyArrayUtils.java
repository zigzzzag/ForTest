package com.mnikiforov.core.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

import static java.lang.Math.min;

/**
 * Created by sbt-nikiforov-mo on 15.06.16.
 */
public class CopyArrayUtils {

    /**
     * Метод наращивает массив, выделяя новый массив того же типа и копируя в него все прежние элементы
     *
     * @param srcArr    Наращиваемый массив. Может быть массивом объектов или же массивом примитивных типов
     * @param newLength Новая длина массива
     * @return Наращенный массив, содержащий все элементы массива srcArr
     */
    public static Object copyOf(Object srcArr, int newLength) {
        Class clazz = srcArr.getClass();

        if (!clazz.isArray()) return null;

        Class componentType = clazz.getComponentType();
        Object newArray = Array.newInstance(componentType, newLength);

        int length = Array.getLength(srcArr);
        System.arraycopy(srcArr, 0, newArray, 0, min(length, newLength));

        return newArray;
    }

    /**
     * В этом методе предпринимается попытка нарастить массив путем выделения нового массива и копирования в него всех
     * прежних элементов
     *
     * @param srcArr    Исходный массив
     * @param newLength Новая длина массива
     * @return Наращенный массив, содержащий все элементы массива srcArr, но он относится к типу Object[], а не к типу
     * массива srcArr
     */
    @Deprecated
    public static Object[] copyOfArray(Object[] srcArr, int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(srcArr, 0, newArray, 0, min(srcArr.length, newLength));
        return newArray;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) copyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Sara", "Micke"};
        b = (String[]) copyOf(b, 10);
        System.out.println(Arrays.toString(b));


        b = (String[]) copyOfArray(b, 20);//Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
        System.out.println(Arrays.toString(b));
    }
}
