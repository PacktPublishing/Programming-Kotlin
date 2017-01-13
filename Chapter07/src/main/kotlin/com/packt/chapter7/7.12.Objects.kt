package com.packt.chapter7

import kotlin.reflect.companionObject
import kotlin.reflect.companionObjectInstance

class Aircraft(name: String, manufacturer: String, capacity: Int) {
  companion object {
    fun boeing(name: String, capacity: Int) = Aircraft(name, "Boeing", capacity)
  }
}

fun companionObjectKClass() {
  val kclass = Aircraft::class
  val companionKClass = kclass.companionObject
}

fun companionObject() {
  val kclass = Aircraft::class
  val companion = kclass.companionObjectInstance as Aircraft.Companion
  companion.boeing("747", 999)
}

class Pizza(name: String)

object PizzaOven {
  fun cook(name: String): Pizza = Pizza(name)
}

fun objectKClass() {
  val kclass = PizzaOven::class
  val oven = kclass.objectInstance as PizzaOven
}