package com.packt.chapter11

import io.kotlintest.specs.StringSpec

class ResourceExample : StringSpec() {

  val input = autoClose(javaClass.getResourceAsStream("/orders.csv"))

  init {
    "your test case" {
      // use input stream here
    }
  }
}