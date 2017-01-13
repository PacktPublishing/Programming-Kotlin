package com.packt.chapter8

inline fun <reified T> runtimeType(): Unit {
  println("My type parameter is " + T::class.qualifiedName)
}

inline fun <reified T> List<Any>.collect(): List<T> {
  return this.filter { it is T }.map { it as T }
}

fun collectExample() {
  val list = listOf("green", false, 100, "blue")
  val strings = list.collect<String>()
}

inline fun <reified T> printT(any: Any): Unit {
  if (any is T) println("I am a tee: $any")
}

fun main(args: Array<String>) {
  printT<Int>(123)
}