package com.mnikiforov.core.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by zigzzzag on 07.10.15.
 */
public class ExceptionType {

    public static void main(String[] args) {
        ExceptionType exceptionType = new ExceptionType();

        //RuntimeException - unchecked
        exceptionType.f_NPE();
        exceptionType.f_IllArgExc();
        exceptionType.f_IndexOutOfBoundsException();
        exceptionType.f_ClassCastException();
        exceptionType.f_IllegalStateException();

        //Exception - checked
        try {
            exceptionType.f_IOExc();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            exceptionType.f_SQLException();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            exceptionType.f_FileNotFoundException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            exceptionType.f_ClassNotFoundException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void f_NPE() throws NullPointerException {
        throw new NullPointerException();
    }

    private void f_IllArgExc() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

    private void f_IllegalStateException() throws IllegalStateException {
        throw new IllegalStateException();
    }

    private void f_IOExc() throws IOException {
        throw new IOException();
    }

    private void f_IndexOutOfBoundsException() throws IndexOutOfBoundsException {
        throw new IndexOutOfBoundsException();
    }

    private void f_ClassCastException() throws ClassCastException {
        throw new ClassCastException();
    }

    private void f_SQLException() throws SQLException {
        throw new SQLException();
    }

    private void f_FileNotFoundException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    private void f_ClassNotFoundException() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }

    private void f_InterruptedException() throws InterruptedException {
        throw new InterruptedException();
    }
}
