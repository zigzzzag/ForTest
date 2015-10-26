/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mnikiforov
 */
public class Logic {

    private static final Logger log = LoggerFactory.getLogger(Logic.class);

    public static void main(String[] args) {
        int a = 0;
        log.info("0: {}", Integer.toBinaryString(a));
        a = ~a;
        log.info("~0: {} {}", a, Integer.toBinaryString(a));
        a >>>= 1;
        log.info("a >>>= 1: {} {} {}({})", a, Integer.MAX_VALUE, Integer.toBinaryString(a), Integer.toBinaryString(a).length());
        a = ~a;
        log.info("a: {} {} {}({})", a, Integer.MIN_VALUE, Integer.toBinaryString(a), Integer.toBinaryString(a).length());

        float b = 1f;
        int i = 0;
        try {
            while (true) {
                i++;
                b *= 2;
                log.info("i = {}, b = {}", i, b);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        log.info("b = {}", b);
    }

    public static boolean[] convertIntToBit() {
        boolean[] bits = new boolean[7];
        return bits;
    }
}
