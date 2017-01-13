package com.packt.chapter7

class SomeClass() {
  @JvmOverloads
  fun foo(name: String = "Harry", location: String = "Cardiff"): Unit {
  }
}