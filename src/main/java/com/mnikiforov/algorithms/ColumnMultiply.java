package com.mnikiforov.algorithms;

public class ColumnMultiply implements MultiplyAlgorithm {

    @Override
    public String multiplay(String arg1, String arg2) {
        byte[] numeralArr1 = strToNumeralArr(arg1);
        byte[] numeralArr2 = strToNumeralArr(arg2);

        byte[] sumColumnArr = new byte[numeralArr1.length + numeralArr2.length + 1];
        int sumColumnArrDelta = 0;
        for (int j = numeralArr2.length - 1; j >= 0; j--) {

            byte[] columnArrJ = new byte[numeralArr1.length + 1];
            for (int i = numeralArr1.length - 1; i >= 0; i--) {
                byte m = (byte) (numeralArr2[i] * numeralArr1[j]);
                if (m < 10) {
                    columnArrJ[i] += m;
                } else {
                    columnArrJ[i] += m % 10;
                    columnArrJ[i - 1] += m / 10;
                }
            }

            for (int i = columnArrJ.length - 1; i >= 0; i--) {
                byte s = (byte) (sumColumnArr[i - sumColumnArrDelta] + columnArrJ[i]);
                if (s < 10) {
                    sumColumnArr[i - sumColumnArrDelta] += s;
                } else {
                    sumColumnArr[i - sumColumnArrDelta] += s % 10;
                    sumColumnArr[i - sumColumnArrDelta - 1]++;
                }
            }
            sumColumnArrDelta++;
        }

        return numeralArrToStr(sumColumnArr);
    }

    private String numeralArrToStr(byte[] numeralArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : numeralArr) {
            sb.append(b);
        }
        return sb.toString();
    }

    private byte[] strToNumeralArr(String str) {
        char[] chars = str.toCharArray();
        byte[] res = new byte[chars.length];
        for (int i = 0; i < chars.length; i++) {
            res[i] = Byte.decode(String.valueOf(chars[i]));
        }

        return res;
    }

    public static void main(String[] args) {
        ColumnMultiply cm = new ColumnMultiply();
        for (byte b : cm.strToNumeralArr("1234567890")) {
            System.err.print(b);
        }
    }
}
