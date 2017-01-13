package com.programming.kotlin.chapter09

class Vector3(val x:Double, val y:Double, val z:Double){
    operator fun component1()=x
    operator fun component2()=y
    operator fun component3()=z
}