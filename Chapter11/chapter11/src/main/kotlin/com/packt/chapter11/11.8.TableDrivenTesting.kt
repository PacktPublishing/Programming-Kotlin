package com.packt.chapter11

import io.kotlintest.specs.StringSpec

class TableExample : StringSpec() {
  init {

    "example of booleans" {

      val table = table(
          headers("a", "b", "c"),
          row(true, true, true),
          row(true, false, true),
          row(true, false, false)
      )

      forAll(table) { a, b, c ->
        a shouldBe true
        if (b)
          c shouldBe true
      }
    }
  }
}