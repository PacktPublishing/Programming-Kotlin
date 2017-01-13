package com.packt.chapter13

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
  val executor = Executors.newFixedThreadPool(4)
  for (k in 1..10) {
    executor.submit {
      println("Processing element $k on thread ${Thread.currentThread()}")
    }
  }
  executor.shutdown()
  executor.awaitTermination(1, TimeUnit.MINUTES)
}