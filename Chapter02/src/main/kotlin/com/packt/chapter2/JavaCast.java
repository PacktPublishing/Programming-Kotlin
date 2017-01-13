package com.packt.chapter2;

public class JavaCast {

    public void printStringLength(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.print(str.length());
        }
    }
}
