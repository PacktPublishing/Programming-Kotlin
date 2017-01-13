package com.packt.chapter11

import io.kotlintest.specs.StringSpec

fun squareRoot(k: Int): Int {
  require(k >= 0)
  return Math.sqrt(k.toDouble()).toInt()
}

class StringMatchers : StringSpec() {
  init {
    "testing string matchers" {
      "hello world" should startWith("hello")
    }

    "an exception should be thrown 1" {
      try {
        squareRoot(-1)
        throw RuntimeException("This test should not pass")
      } catch (e: Exception) {
        // noop
      }
    }

    "an exception should be thrown 2" {
      shouldThrow<IllegalArgumentException> {
        squareRoot(-1)
      }
    }

    "an example of AND operator" {
      val thisString = "hello world"
      thisString should (haveLength(11) and include("llo wor"))
    }

    "an example of OR operator" {
      val thisString = "hello world"
      thisString should (haveLength(11) or include("goodbye"))
    }
  }
}