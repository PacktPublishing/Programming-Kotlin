package com.packt.chapter2

class Person(name: String) {
  fun printMe() = println(this)
}

class Building(val address: String) {
  inner class Reception(telephone: String) {
    fun printMyAddress() = println(this@Building.address)
  }
}