package com.packt.chapter2

fun stringIteration(string: String) {
  for (char in string) {
    println(char)
  }
}

fun arrayIndices(array: Array<String>) {
  for (index in array.indices) {
    println("Element $index is ${array[index]}")
  }
}