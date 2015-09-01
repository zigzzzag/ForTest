package com.mnikiforov.spring_in_action.systemprops;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by SBT-Nikiforov-MO on 01.09.2015.
 */
public class SysPropsMain {

    private static final Logger log = LoggerFactory.getLogger(SysPropsMain.class);

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("SysProps.xml");

        SystemPropsSpring sps = (SystemPropsSpring) appContext.getBean("sysprops_id");
        log.info("{}", sps);
    }
}
