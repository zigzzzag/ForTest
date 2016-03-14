package com.mnikiforov.spring_in_action.method_replace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sbt-nikiforov-mo on 14.03.16.
 */
public class MethodReplaceRun {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/MethodReplace.xml");

        System.out.println();

        Performer magician = (Performer) ctx.getBean("harry");
        magician.perform();
    }
}
