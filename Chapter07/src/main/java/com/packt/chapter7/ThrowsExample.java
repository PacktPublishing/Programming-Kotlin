package com.packt.chapter7;

import java.io.FileNotFoundException;

public class ThrowsExample {
    public void throwsExample() throws FileNotFoundException {
        boolean exists = new File("somefile.txt").exists();
        System.out.println("File exists");
    }
}
