package com.mnikiforov.aop.spring.annotated;

import org.springframework.stereotype.Component;

/**
 * Created by sbt-nikiforov-mo on 1/11/17.
 */
@Component("longRunner")
public class SomeObjectAnnotated {

    public void longRunningMethod() {
        try {
            int delay = (int) (Math.random() * 10);
            System.out.println("Delay time : " + delay);
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
