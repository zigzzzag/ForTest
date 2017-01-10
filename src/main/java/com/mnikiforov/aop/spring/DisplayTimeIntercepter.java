package com.mnikiforov.aop.spring;

import java.util.Date;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by zigzzzag on 1/10/17.
 */
public class DisplayTimeIntercepter implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("Time before method launch: " + new Date());
        Object value = mi.proceed();
        System.out.println("Time after method launch: " + new Date());
        return value;
    }
}
