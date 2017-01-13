package com.packt.chapter5

fun higherorder() {

}

fun foo(value: String, function: (String) -> String): Unit = println(function(value))

fun invokeFoo() {
  foo("hello", { str -> str.reversed() })
}

fun foo2(str: String) {
  val reversed = str.reversed()
  println(reversed)
}

fun numbers1() {

  val ints = listOf(1, 2, 3, 4, 5, 6)

  val evens = mutableListOf<Int>()
  val odds = mutableListOf<Int>()
  for (k in ints) {
    if (k % 2 == 0)
      evens.add(k)
    else
      odds.add(k)
  }
}

fun numbers2() {
  val ints = listOf(1, 2, 3, 4, 5, 6)
  val evens = ints.filter { it % 2 == 0 }
  val odd = ints.filter { it % 2 == 1 }
}

fun bar(): (String) -> Unit = { str -> str.reversed() }

fun usingBar() {
  val reversi = bar()
  reversi("hello")
  reversi("world")
}

fun modulo(k: Int): (Int) -> Boolean = { it % k == 0 }

fun filternumbers() {
  val ints = listOf(1, 2, 3, 4, 5, 6)
  val evens = ints.filter(modulo(2))
  val odd = ints.filter(modulo(1))
}

fun funassignment() {

  val isEven: (Int) -> Boolean = modulo(2)
  listOf(1, 2, 3, 4).filter(isEven)
  listOf(5, 6, 7, 8).filter(isEven)

}


