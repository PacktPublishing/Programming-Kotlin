package com.packt.chapter2

fun main(args: Array<String>) {

  val leftShift = 1 shl 2
  val rightShift = 1 shr 2
  val unsignedRightShift = 1 ushr 2

  val and = 1 and 0x00001111
  val or = 1 and 0x00001111
  val xor = 1 xor 0x00001111
  val inv = 1.inv()
}
