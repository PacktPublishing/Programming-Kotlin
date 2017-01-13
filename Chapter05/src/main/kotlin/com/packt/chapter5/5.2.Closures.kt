package com.packt.chapter5

import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

fun paramClosure() {

  class Student(val firstName: String, val lastName: String)

  // accesses database to load student values
  fun loadStudents(): List<Student> = TODO()

  fun students(lastName: String): List<Student> {
    val regex = ".*$lastName.*".toRegex()
    return loadStudents().filter { it.lastName.matches(regex) }
  }
}

fun localValClosure() {
  val counter = AtomicInteger(0)
  val cores = Runtime.getRuntime().availableProcessors()
  val threadPool = Executors.newFixedThreadPool(cores)
  threadPool.submit {
    println("I am thread number ${counter.incrementAndGet()}")
  }
}

fun mutateClosure() {
  var containsNegative = false
  val ints = listOf(0, 1, 2, 3, 4, 5)
  ints.forEach {
    if (it < 0)
      containsNegative = true
  }
}