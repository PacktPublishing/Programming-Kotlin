package com.programming.kotlin.chapter06


class Container {
    lateinit var delayedInitProperty: DelayedInstance
    fun initProperty(instance: DelayedInstance): Unit {
        this.delayedInitProperty = instance
    }
}

class DelayedInstance (val number:Int)