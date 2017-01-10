package com.mnikiforov.aop.spring;


import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by zigzzzag on 1/10/17.
 */
public class AroundAdviceProgrammedExample {

    public static void main(String[] args) {
        SomeObject so = new SomeObject();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(so);
        pf.addAdvice(new DisplayTimeIntercepter());

        SomeObject proxy = (SomeObject) pf.getProxy();
        proxy.longLoop();
    }
}
