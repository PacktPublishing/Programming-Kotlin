package com.packt.chapter4;

public class OverloadsForDefaults {

    public String join(String[] array) {
        return join(array, "");
    }

    public String join(String[] array, String prefix) {
        return join(array, prefix, "");
    }

    public String join(String[] array, String prefix, String separator) {
        return join(array, prefix, separator, "");
    }

    public String join(String[] array, String prefix, String separator, String suffix) {
        return null; // actual impl
    }

}
