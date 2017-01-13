package com.packt.chapter7

import kotlin.reflect.KClass
import kotlin.reflect.declaredMemberExtensionFunctions
import kotlin.reflect.functions
import kotlin.reflect.memberFunctions
import kotlin.reflect.memberProperties

class Rocket() {

  var lat: Double = 0.0
  var long: Double = 0.0

  fun explode() {
    println("Boom")
  }

  fun setCourse(lat: Double, long: Double) {
    require(lat.isValid())
    require(long.isValid())
    this.lat = lat
    this.long = long
  }

  fun Double.isValid() = Math.abs(this) <= 180
}

fun <T : Any> printFunctions(kclass: KClass<T>) {
  kclass.declaredMemberExtensionFunctions
  kclass.memberFunctions.forEach {
    println(it.name)
  }
}

fun <T : Any> printProperties(kclass: KClass<T>) {
  kclass.memberProperties.forEach {
    println(it.name)
  }
}

fun <T : Any> invokeExplodeFunction(kclass: KClass<T>) {
  val function = kclass.functions.find { it.name == "explode" }
  function?.call(Rocket())
}

fun main(args: Array<String>) {
  printFunctions(Rocket::class)
  printProperties(Rocket::class)
  invokeExplodeFunction(Rocket::class)
}
