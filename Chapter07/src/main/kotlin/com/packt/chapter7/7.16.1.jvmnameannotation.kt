package com.packt.chapter7

@JvmName("filterStrings")
fun filter(list: List<String>): Unit {
}

@JvmName("filterInts")
fun filter(list: List<Int>): Unit {
}

fun test() {
  println(filter(listOf(1, 2, 3)))
}

