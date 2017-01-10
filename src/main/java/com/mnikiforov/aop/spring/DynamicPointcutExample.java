package com.mnikiforov.aop.spring;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Created by sbt-nikiforov-mo on 1/10/17.
 */
public class DynamicPointcutExample {

    public static void main(String[] args) {
        SomeObject so = new SomeObject();
        NotDecoratedSomeObject ndso = new NotDecoratedSomeObject();

        Pointcut pointcut = new DynamicPointcut();
        Advice advice = new LogInterceptor();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);


        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(so);

        SomeObject soProxy = (SomeObject) pf.getProxy();


        pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(ndso);

        NotDecoratedSomeObject ndsoProxy = (NotDecoratedSomeObject) pf.getProxy();


        System.out.println("SomeObject, printInteger(5)");
        soProxy.printInteger(5);

        System.out.println("SomeObject, printInteger(25)");
        soProxy.printInteger(25);

        System.out.println("SomeObject, longLoop");
        soProxy.longLoop();

        System.out.println("NotDecoratedSomeObject, printInteger(5)");
        ndsoProxy.printInteger(5);

        System.out.println("NotDecoratedSomeObject, printInteger(25)");
        ndsoProxy.printInteger(25);

        System.out.println("NotDecoratedSomeObject, longLoop");
        ndsoProxy.longLoop();
    }
}
