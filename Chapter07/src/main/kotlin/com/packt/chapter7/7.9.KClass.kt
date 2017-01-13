package com.packt.chapter7

import kotlin.reflect.KClass

fun gettingAKClass() {
  val name = "George"
  val kclass: KClass<String> = name::class
  val kclass2: KClass<String> = String::class
  val kclass3 = Class.forName("com.packt.MyType").kotlin
}

fun oneKClassPerType() {
  val kclass1: KClass<String> = "harry"::class
  val kclass2: KClass<String> = "victoria"::class
  val kclass3: KClass<String> = String::class
}