package com.packt.chapter13

import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

fun boundedBuffer() {
  val buffer = LinkedBlockingQueue<Int>()

  thread {
    val random = Random()
    while (true) {
      buffer.put(random.nextInt())
    }
  }

  thread {
    while (true) {
      val item = buffer.take(0)
      println("Consumed item $item")
    }
  }
}