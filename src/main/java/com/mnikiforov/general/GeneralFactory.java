package com.mnikiforov.general;

/**
 * Created by SBT-Nikiforov-MO on 26.03.2015.
 */
public class GeneralFactory {

    public static String convertArrayToString(Object[] array) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        for (int i = 0; i < array.length; i++) {
            stringBuffer.append('\'');
            stringBuffer.append(array[i].toString());
            stringBuffer.append('\'');
            if (i < array.length - 1)
                stringBuffer.append(',');
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }
}
