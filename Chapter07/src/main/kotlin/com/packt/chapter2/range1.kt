package com.packt.chapter2

fun r1() {
  val aToZ = "a".."z"
  val isTrue = "c" in aToZ

  val oneToNine = 1..9
  val isFalse = 11 in oneToNine

  val countingDown = 100.downTo(0)
  val rangeTo = 10.rangeTo(20)

  val oneToFifty = 1..50
  val oddNumbers = oneToFifty.step(2)

  val countingDownEvenNumbers = (2..100).step(2).reversed()

}