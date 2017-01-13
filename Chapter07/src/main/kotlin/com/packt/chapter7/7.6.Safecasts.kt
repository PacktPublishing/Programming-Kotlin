package com.packt.chapter7

fun safeCast() {
  val location: Any = "London"

  val safeString: String? = location as? String
  val safeInt: Int? = location as? Int
}