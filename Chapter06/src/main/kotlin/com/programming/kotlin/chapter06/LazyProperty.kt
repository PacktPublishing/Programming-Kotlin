package com.programming.kotlin.chapter06

class WithLazyProperty {
    val foo: Int by lazy (){
        println("Initializing foo")
        2
    }
}

class WithLazyPropertyWithLocking{
    val lockingField = Any()

    val foo: Int by lazy(lockingField, {
        println("Initializing foo");
        2
    })
}