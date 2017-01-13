package com.packt.chapter8

fun <T> random(one: T, two: T, three: T): T = TODO()

fun <K, V> put(key: K, value: V): Unit = TODO()

fun main() {
  val str: String = random("hello", "wilkommen", "bonjour")
  val any: Any = random("a", 1, false)
}