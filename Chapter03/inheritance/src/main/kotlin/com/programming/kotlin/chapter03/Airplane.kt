package com.programming.kotlin.chapter03

interface Airplane {
    fun fly(): Unit
}


abstract class SingleEngineAirplane protected constructor() {
    abstract fun fly()
}

class CesanaAirplane : SingleEngineAirplane() {
    final override fun fly() {
        println("Flying a cesna")
    }
}