package com.packt.chapter8

import java.io.Serializable

fun <T : Comparable<T>> min(first: T, second: T): T {
  val k = first.compareTo(second)
  return if (k <= 0) first else second
}

fun <T> min2(first: T, second: T): T
    where T : Comparable<T>,
T : Serializable {
  val k = first.compareTo(second)
  return if (k <= 0) first else second
}

class MultipleBoundedClass<T> where T : Comparable<T>, T : Serializable

fun minExample() {
  val a = min(4, 5)
  val b = min("e", "c")
}

class Year(val value: Year) : Comparable<Year> {
  override fun compareTo(other: Year): Int = this.value.compareTo(other.value)
}

class SerializableYear(val value: Int) : Comparable<SerializableYear>, Serializable {
  override fun compareTo(other: SerializableYear): Int = this.value.compareTo(other.value)
}

fun minSerializableExample() {
  //val a = min2(Year(1969), Year(1802))
  val b = min2(SerializableYear(1969), SerializableYear(1802))
}