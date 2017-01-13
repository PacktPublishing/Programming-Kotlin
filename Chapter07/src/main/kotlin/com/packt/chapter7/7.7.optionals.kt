package com.packt.chapter7

import java.util.*

val optionalName: Optional<String> = Optional.of("william")

val empty: Optional<String> = Optional.empty()

fun lookupAddress(postcode: String): Optional<String> = TODO()
fun lookupHousePrice(address: String): Optional<Int> = TODO()

fun orElse() {
  val address = lookupAddress("AB1 1BC").orElse("1600 Pennsylvania Avenue")
}

fun qe() {
  val price = lookupAddress("AB1 1BC").flatMap(::lookupHousePrice).orElse(0)
}

