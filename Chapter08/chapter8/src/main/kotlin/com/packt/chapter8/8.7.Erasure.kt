package com.packt.chapter8

fun printInts(list: Set<Int>): Unit {
  for (int in list) println(int)
}

fun printStrings(list: Set<String>): Unit {
  for (string in list) println(string)
}

fun <T : Comparable<T>> max(list: List<T>): T {
  var max = list.first()
  for (t in list) {
    if (t > max)
      max = t
  }
  return max
}