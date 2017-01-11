package com.mnikiforov.aop.spring.annotated;

import java.util.Date;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by zigzzzag on 1/11/17.
 */
@Aspect
@Component
public class AnnotatedLogInterceptor {

    @Around(value = "execution(void com.mnikiforov.aop.spring.annotated.SomeObjectAnnotated.longRunningMethod())")
    public Object invoke(ProceedingJoinPoint invocation) throws Throwable {

        System.out.println("Start executing " + invocation.toShortString() + " at " + new Date());

        Object value = invocation.proceed();

        System.out.println("End executing " + invocation.toShortString() + " at " + new Date());

        return value;
    }
}
