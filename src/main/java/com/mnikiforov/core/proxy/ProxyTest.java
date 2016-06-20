package com.mnikiforov.core.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zigzag on 20.06.2016.
 */
public class ProxyTest {


    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        //заполнить массив elements проуст-объектами целых чисел от 1 до 1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        //сфлрмировать случайное число
        Integer key = new Random().nextInt(elements.length) + 1;

        //выполнить поискпо критею key
        int result = Arrays.binarySearch(elements, key);

        //вывести совпавший элемент, если таковой найден
        if (result >= 0) System.out.println(elements[result]);
    }
}

/**
 * Обработчик вызовов, выводящий сначала имя метода и его параметры, а затем вызывающий исходный метод
 */
class TraceHandler implements InvocationHandler {

    private Object target;

    /**
     * Конструирует объекты типа {@link TraceHandler}
     *
     * @param target Неявный параметр вызова метода
     */
    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //вывести неявный параметр
        System.out.print(target);

        //вывести имя метода
        System.out.print("." + method.getName() + "(");

        //вывести явные параметры
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(args[i]);
            }
        }
        System.out.println(")");

        return method.invoke(target, args);
    }
}
