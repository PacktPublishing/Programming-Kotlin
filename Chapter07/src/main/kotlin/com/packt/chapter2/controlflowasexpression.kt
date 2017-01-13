package com.packt.chapter2

import java.io.IOException
import java.util.*

fun expression() {
  "hello".startsWith("h")
}

fun statement() {
  val a = 1
}

fun isZero(x: Int): Boolean {
  return if (x == 0) true else false
}

fun c1() {
  val date = Date()
  val today = if (date.year == 2016) true else false
}

fun t1() {
  fun readFile() = {}
  val success = try {
    readFile()
    true
  } catch (e: IOException) {
    false
  }
}