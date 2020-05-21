package com.ljr.study.view;

public class Texception  {
    static class IException extends Exception {
    }

    static class RException extends RuntimeException {
    }

    void print() throws IException {
    }

    void printR() throws RException {
    }

    void printT() {
        throw new RException();
    }

    void printTR() throws IException {
        throw new IException();
    }
    void test() {
        printR();
        try {
            print();
        } catch (IException e) {
            e.printStackTrace();
        }
    }
}
