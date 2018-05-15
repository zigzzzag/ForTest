package com.mnikiforov.core.unboxing;

public class UnboxingTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long res = withUnboxing();
        System.err.println("withUnboxing res:    " + res + "; time: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        res = withoutUnboxing();
        System.err.println("withoutUnboxing res: " + res + "; time: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static long withUnboxing() {
        Long total = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            total += i;
        }
        return total;
    }

    private static long withoutUnboxing() {
        long total = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            total += i;
        }
        return total;
    }
}
