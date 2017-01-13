package com.packt.chapter2

fun col1() {
  val list = listOf(1, 2, 3, 4)
  for (k in list) {
    println(k)
  }

  val set = setOf(1, 2, 3, 4)
  for (k in set) {
    println(k)
  }
}

fun colrange() {
  val oneToTen = 1..10
  for (k in oneToTen) {
    for (j in 1..5) {
      println(k * j)
    }
  }
}

fun stringcol() {
  for (char in "string") {
    println(char)
  }
}