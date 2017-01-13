package com.packt.chapter11

import com.sksamuel.koors.Random
import io.kotlintest.properties.Gen
import io.kotlintest.specs.StringSpec

class PropertyExample : StringSpec() {
  init {

    "String.size" {
      forAll({ a: String, b: String ->
        (a + b).length == a.length + b.length
      })
    }

    "squareRoot" {
      forAll(Gen.int(), { k ->
        val square = squareRoot(k)
        square * square == k
      })
    }

    "using a collection picker" {
      val values = listOf("pick", "one", "of", "these")
      forAll(Gen.oneOf(values), { element ->
        // test logic
        values.contains(element)
      })
    }

    "using a range generator" {
      forAll(Gen.choose(0, 10000), { k ->
        // test logic
        k > 0
      })
    }
  }
}

fun evenInts() = object : Gen<Int> {
  override fun generate(): Int {
    while (true) {
      val next = Random.default.nextInt()
      if (next % 2 == 0)
        return next
    }
  }
}