package com.mnikiforov.core.enumtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class EnumEqualsTest {

    private static final Logger LOG = LoggerFactory.getLogger(EnumEqualsTest.class);

    public enum Seasons {
        WINTER,
        SPRING,
        SUMMER,
        AUTUMN
    }

    @SuppressWarnings("ObjectEqualsNull")
    public static void main(String[] args) {
        LOG.info("Seasons: " + Arrays.toString(Seasons.values()));

        try {
            Seasons.valueOf(null);
        } catch (NullPointerException e) {
            LOG.error("Seasons.valueOf(null) throw NPE", e);
        }

        try {
            Seasons.valueOf("aaa");
        } catch (IllegalArgumentException e) {
            LOG.error("throwing IllegalArgumentException with not existing name", e);
        }

        LOG.info("null == Seasons.WINTER -> " + (null == Seasons.WINTER));
        LOG.info("Seasons.SUMMER.equals(null) -> " + Seasons.SUMMER.equals(null));
    }
}
