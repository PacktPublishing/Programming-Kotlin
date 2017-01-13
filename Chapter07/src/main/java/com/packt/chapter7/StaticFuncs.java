package com.packt.chapter7;

public class StaticFuncs {
    public StaticFuncs() {
        HasStaticFuncs.INSTANCE.foo();
        HasStaticFuncs.foo();
    }
}
