package com.mnikiforov.aop.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by zigzzzag on 1/10/17.
 */
public class LogInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("Start executing: " + mi.getMethod().getName());
        Object value = mi.proceed();
        System.out.println("End executing: " + mi.getMethod().getName());
        return value;
    }
}
