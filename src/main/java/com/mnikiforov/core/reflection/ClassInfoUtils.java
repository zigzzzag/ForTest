package com.mnikiforov.core.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by sbt-nikiforov-mo on 14.06.16.
 */
public class ClassInfoUtils {

    public static void showFullInfoClass(Class clazz) {
        showFullInfoClass(clazz.getName());
    }


    /**
     * выводит всю информацию о классе
     *
     * @param className название класаа
     */
    public static void showFullInfoClass(String className) {
        Class clazz;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Class superClass = clazz.getSuperclass();
        String modifiers = Modifier.toString(clazz.getModifiers());
        if (modifiers.length() > 0) {
            System.out.print(modifiers + " ");
        }
        System.out.print("class " + className);

        if (superClass != null && superClass != Object.class) {
            System.out.print(" extends " + superClass.getName());
        }

        System.out.print("\n{\n");

        printConstructors(clazz);
        System.out.println();

        printMethods(clazz);
        System.out.println();

        printFields(clazz);
        System.out.println();
    }

    /**
     * Выводит все конструкторы класса
     *
     * @param clazz
     */
    public static void printConstructors(Class clazz) {
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String cName = clazz.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(cName + "(");

            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * выводит все методы класса
     *
     * @param clazz
     */
    public static void printMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            Class returnType = m.getReturnType();
            String methodName = m.getName();

            System.out.print(" ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(returnType.getName() + " " + methodName + "(");

                Class[] paramTypes = m.getParameterTypes();
                for (int i = 0; i < paramTypes.length; i++) {
                    if (i > 0) {
                        System.out.print(", ");
                    }
                    System.out.print(paramTypes[i].getName());
                }
                System.out.println(");");
            }
        }
    }

    /**
     * выводит все поля
     *
     * @param clazz
     */
    public static void printFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();
            String fieldName = f.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getCanonicalName() + " " + fieldName + ";");
        }
    }

    public static void main(String[] args) {
        ClassInfoUtils.showFullInfoClass("java.lang.Double");
//        ClassInfoUtils.showFullInfoClass("java.util.ArrayList");
//        ClassInfoUtils.showFullInfoClass("java.lang.Error");
    }
}
