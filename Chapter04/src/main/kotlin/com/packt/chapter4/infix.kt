package com.packt.chapter4

class Age(val value: Int) {
  infix fun max(other: Age): Age = if (value > other.value) this else other
}

fun foo() {
  val sam = Age(37)
  val stef = Age(36)
  val oldest = sam max stef
}

fun toVsPair() {

  val pair1 = Pair("london", "uk")
  val pair2 = "london" to "uk"

  val map1 = mapOf(Pair("London", "UK"), Pair("Bucharest", "Romania"))
  val map2 = mapOf("London" to "UK", "Bucharest" to "Romania")
}