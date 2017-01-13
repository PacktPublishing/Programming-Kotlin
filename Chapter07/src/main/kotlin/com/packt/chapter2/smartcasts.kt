package com.packt.chapter2

fun printStringLength(any: Any) {
  if (any is String) {
    println(any.length)
  }
}


fun isString(any: Any): Boolean {
  return if (any is String) true else false
}

fun isEmptyString(any: Any): Boolean {
  return any is String && any.length == 0
}

fun isNotStringOrEmpty(any: Any): Boolean {
  return any !is String || any.length == 0
}

fun length(any: Any): Int {
  val string = any as String
  return string.length
}

fun safeCast() {
  val any = "/home/users"
  val string: String? = any as String
  val file: File? = any as File
}