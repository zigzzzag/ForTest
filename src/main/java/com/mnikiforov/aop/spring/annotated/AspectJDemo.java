package com.mnikiforov.aop.spring.annotated;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sbt-nikiforov-mo on 1/11/17.
 */
public class AspectJDemo {

    public static void main(String[] args) {
        ApplicationContext beanFactory =
                new ClassPathXmlApplicationContext("spring/AopSpring.xml");

        SomeObjectAnnotated soa =
                (SomeObjectAnnotated) beanFactory.getBean("longRunner");

        soa.longRunningMethod();
    }
}
