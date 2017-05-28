package com.mnikiforov.core.stringtest;

public enum CustomStringUtils {

    INSTANCE;

    public int getDigitsCountSlow(String str) {
        if (str == null) {
            return 0;
        }

        return str.replaceAll("\\D", "").length();
    }

    public int getDigitsCountFast(String str) {
        if (str == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
