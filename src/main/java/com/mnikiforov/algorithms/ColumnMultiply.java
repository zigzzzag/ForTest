package com.mnikiforov.algorithms;

public class ColumnMultiply implements MultiplyAlgorithm {

    @Override
    public String multiply(String arg1, String arg2) {
        byte[] numeralArr1 = strToNumeralArr(arg1);
        byte[] numeralArr2 = strToNumeralArr(arg2);

        byte[] sumColumnArr = new byte[numeralArr1.length + numeralArr2.length];
        int sumColumnArrDelta = 0;
        for (int j = numeralArr2.length - 1; j >= 0; j--) {

            byte[] columnArrJ = new byte[numeralArr1.length + 1];
            for (int i = numeralArr1.length - 1; i >= 0; i--) {
                byte m = (byte) (numeralArr2[j] * numeralArr1[i]);
                if (m < 10) {
                    columnArrJ[i + 1] += m;
                } else {
                    columnArrJ[i + 1] += m % 10;
                    columnArrJ[i] += m / 10;
                }
            }

            for (int i = columnArrJ.length - 1; i >= 0; i--) {
                int sumColumnArrPos = sumColumnArr.length - 1 -(columnArrJ.length - 1 - i) - sumColumnArrDelta;
                byte s = (byte) (sumColumnArr[sumColumnArrPos] + columnArrJ[i]);
                if (s < 10) {
                    sumColumnArr[sumColumnArrPos] = s;
                } else {
                    sumColumnArr[sumColumnArrPos] = (byte) (s % 10);
                    sumColumnArr[sumColumnArrPos - 1]++;
                }
            }
            sumColumnArrDelta++;
        }

        return numeralArrToStr(sumColumnArr);
    }

    private String numeralArrToStr(byte[] numeralArr) {
        StringBuilder sb = new StringBuilder();

        boolean firstIsZero = true;
        for (int i = 0; i < numeralArr.length; i++) {
            if (numeralArr[i] == 0) {
                if (!firstIsZero) {
                    sb.append(numeralArr[i]);
                }
            } else {
                sb.append(numeralArr[i]);
                firstIsZero = false;
            }
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
