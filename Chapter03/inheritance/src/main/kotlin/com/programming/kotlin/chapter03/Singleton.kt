package com.programming.kotlin.chapter03

object Singleton{
    private var count = 0
            ;
    fun doSomething():Unit {
        println("Calling a doSomething (${++count} call/-s in total)")
    }
}

open class SingletonParent(var x:Int){
    fun something():Unit{
        println("X=$x")
    }
}

object SingletonDerive:SingletonParent(10){

}