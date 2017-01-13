package com.packt.chapter4;

import java.io.File;
import java.io.IOException;

public class ThrowsFromJava {
    public void test() {
        try {
            Chapter4.createDirectory(new File("mobydick.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
