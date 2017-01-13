package com.packt.chapter2

import java.io.File

fun eq1() {
  val a = File("/mobydick.doc")
  val b = File("/mobydick.doc")
  val isFalse = a === b
  val isTrue = a !== b
}

fun eq2() {
  val a = File("/mobydick.doc")
  val b = File("/mobydick.doc")
  val isTrue = a == b
}