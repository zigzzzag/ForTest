package com.mnikiforov.advanced_java.annotations;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SBT-Nikiforov-MO on 11.08.2015.
 */
public class AnnotationProcessor {

    public static Map<String, Object> serviceMap = new HashMap<>();

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        loadService("com.mnikiforov.advanced_java.annotations.LazyService");
        loadService("com.mnikiforov.advanced_java.annotations.SimpleService");
        loadService("java.lang.String");

        inspectService(SimpleService.class);
        System.out.println("------------------------------------------------");
        inspectService(LazyService.class);
        System.out.println("------------------------------------------------");
        inspectService(String.class);
        System.out.println("------------------------------------------------");
        inspectService(Class.class);
    }

    public static void inspectService(Class<?> service) {
        Class<?> superClass = service.getSuperclass();
        if (service.isAnnotationPresent(Service.class)) {
            Service ann = service.getAnnotation(Service.class);
            System.out.println(service.getSimpleName() + ": " + ann.name() + "; superClass=" + superClass.getSimpleName());
        } else {
            System.out.println(service.getSimpleName() + " have not Service annotiation!!!" + "; superClass=" + superClass.getSimpleName());
        }

        Method[] methods = service.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Init.class)) {
                System.out.println("Method: " + m.getName() + " annotated Service");
                if (!service.getAnnotation(Service.class).lazyLoad()) {
                    try {
                        m.invoke(serviceMap.get(service.getAnnotation(Service.class).name()));
                    } catch (Exception e) {
                        Init ann = m.getAnnotation(Init.class);
                        if (!ann.suppressException()) {
                            e.printStackTrace();
                        } else {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    public static void loadService(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        if (clazz.isAnnotationPresent(Service.class)) {
            Object serviceObj = clazz.newInstance();
            serviceMap.put(clazz.getAnnotation(Service.class).name(), serviceObj);
        }
    }
}
