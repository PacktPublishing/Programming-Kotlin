package com.packt.chapter5

fun shortfun() {
  listOf(1, 2, 3).filter { it > 1 }
}

fun anonymousFunctions() {
  fun(a: String, b: String): String = a + b

  val ints = listOf(1, 2, 3)
  val evens = ints.filter(fun(k: Int) = k % 2 == 0)

  val evens2 = ints.filter(fun(k) = k % 2 == 0)
}

