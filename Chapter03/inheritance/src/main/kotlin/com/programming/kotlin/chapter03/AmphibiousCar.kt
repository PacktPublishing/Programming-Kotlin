package com.programming.kotlin.chapter03

interface Drivable {
    fun drive()
}

interface Sailable {
    fun saill()
}

class AmphibiousCar(val name: String) : Drivable, Sailable {
    override fun drive() {
        println("Driving...")
    }

    override fun saill() {
        println("Sailling...")
    }
}