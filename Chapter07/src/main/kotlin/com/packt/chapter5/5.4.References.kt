package com.packt.chapter5

fun isEven(k: Int): Boolean = k % 2 == 0

fun wrapped() {
  val ints = listOf(1, 2, 3, 4, 5)
  ints.filter { com.packt.chapter5.isEven(it) }
}

fun funref() {
  val ints = listOf(1, 2, 3, 4, 5)
  ints.filter(::isEven)
}

fun Int.isOdd(): Boolean = this % 1 == 0

fun extFunRef() {
  val ints = listOf(1, 2, 3, 4, 5)
  ints.filter { it.isOdd() }
}

fun extFunRef2() {
  val ints = listOf(1, 2, 3, 4, 5)
  ints.filter(Int::isOdd)
}

fun String.isBounded(prefix: Char, suffix: Char): Boolean = this.startsWith(prefix) && this.endsWith(suffix)

fun String.bounds(): Pair<Char, Char> = this.first() to this.last()

fun extFunRef3() {

  fun foo(a: Double, b: Double, fn: (Double, Double) -> Double) = fn(a, b)
  val a = foo(1.0, 2.0, { a, b -> Math.pow(a, b) })
  val b = foo(1.0, 2.0, Math::pow)
}

fun unboundSubstring() {
  fun String.equalsIgnoreCase(other: String) = this.toLowerCase() == other.toLowerCase()
  listOf("foo", "moo", "boo").filter { (String::equalsIgnoreCase)(it, "bar") }
}