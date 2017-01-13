package com.packt.chapter5

fun <A, B, C> compose2(fn1: (A) -> B, fn2: (B) -> C): (A) -> C = { a ->
  val b = fn1(a)
  val c = fn2(b)
  c
}

fun composeExample() {

  val f = String::length
  val g = Any::hashCode
  val fog = compose2(f, g)
  println(fog("what is the hash of my length?"))

}

infix fun <P1, R, R2> Function1<P1, R>.compose(fn: (R) -> R2): (P1) -> R2 = {
  fn(this(it))
}

fun infixexample() {
  val f = String::length
  val g = Any::hashCode
  val fog = f compose g
}

operator infix fun <P1, R, R2> Function1<P1, R>.times(fn: (R) -> R2): (P1) -> R2 = {
  fn(this(it))
}

fun opexample() {
  val f = String::length
  val g = Any::hashCode
  val fog = f * g
}