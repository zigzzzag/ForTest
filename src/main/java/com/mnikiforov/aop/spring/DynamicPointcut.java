package com.mnikiforov.aop.spring;

import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

/**
 * Created by zigzzzag on 1/10/17.
 */
public class DynamicPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return method.getName().equals("printInteger");
    }

    @Override
    public boolean matches(Method method, Class<?> clazz, Object[] args) {
        if (args.length == 0) {
            return false;
        }

        Object obj = args[0];
        if (obj instanceof Integer) {
            return (Integer) obj > 10;
        } else {
            return false;
        }
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                return clazz == SomeObject.class;
            }
        };
    }
}
