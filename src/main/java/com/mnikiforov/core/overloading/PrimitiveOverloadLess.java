package com.mnikiforov.core.overloading;

/**
 * Created by zigzzzag on 15.02.16.
 */
public class PrimitiveOverloadLess {

    public static void main(String[] args) {
        PrimitiveOverloadLess op = new PrimitiveOverloadLess();
        op.testConstVal();
        op.testChar();
        op.testByte();
        op.testShort();
        op.testInt();
        op.testLong();
        op.testFloat();
        op.testDouble();
    }

    void testConstVal() {
        print("5:    ");
        f1(5);f2(5);f3(5);f4(5);f5(5);f6(5);f7(5);
        System.out.println();
    }

    void testChar() {
        char x = 'x';
        print("char: ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    void testByte() {
        byte x = 0;
        print("byte: ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    void testShort() {
        short x = 0;
        print("short: ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    void testInt() {
        int x = 0;
        print("int: ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    void testLong() {
        long x = 0;
        print("long: ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    void testFloat() {
        float x = 0;
        print("float: ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    void testDouble() {
        double x = 0;
        print("double: ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    void f1(char x)   {print("f1(char)");}
    void f1(byte x)   {print("f1(byte)");}
    void f1(short x)  {print("f1(short)");}
    void f1(int x)    {print("f1(int)");}
    void f1(long x)   {print("f1(long)");}
    void f1(float x)  {print("f1(float)");}
    void f1(double x) {print("f1(double)");}

    void f2(byte x)   {print("f2(byte)");}
    void f2(short x)  {print("f2(short)");}
    void f2(int x)    {print("f2(int)");}
    void f2(long x)   {print("f2(long)");}
    void f2(float x)  {print("f2(float)");}
    void f2(double x) {print("f2(double)");}

    void f3(short x)  {print("f3(short)");}
    void f3(int x)    {print("f3(int)");}
    void f3(long x)   {print("f3(long)");}
    void f3(float x)  {print("f3(float)");}
    void f3(double x) {print("f3(double)");}

    void f4(int x)    {print("f4(int)");}
    void f4(long x)   {print("f4(long)");}
    void f4(float x)  {print("f4(float)");}
    void f4(double x) {print("f4(double)");}

    void f5(long x)   {print("f5(long)");}
    void f5(float x)  {print("f5(float)");}
    void f5(double x) {print("f5(double)");}

    void f6(float x)  {print("f6(float)");}
    void f6(double x) {print("f6(double)");}

    void f7(double x) {print("f7(double)");}

    void print(Object o) {
        System.out.format("%-11s", " " + o);
    }
}
