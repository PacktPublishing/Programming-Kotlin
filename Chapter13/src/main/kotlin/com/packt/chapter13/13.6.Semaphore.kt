package com.packt.chapter13

import java.util.*
import java.util.concurrent.Semaphore
import kotlin.concurrent.thread


fun brokenBufferImpl() {

  val buffer = mutableListOf<Int>()
  val maxSize = 8

  (1..2).forEach {
    thread {
      val random = Random()
      while (true) {
        if (buffer.size < maxSize)
          buffer.plus(random.nextInt())
      }
    }
  }

  (1..2).forEach {
    thread {
      while (true) {
        if (buffer.size > 0) {
          val item = buffer.remove(0)
          println("Consumed item $item")
        }
      }
    }
  }
}

fun semaphore1() {

  val emptyCount = Semaphore(8)
  val fillCount = Semaphore(0)
  val buffer = mutableSetOf<Int>()

  thread {
    val random = Random()
    while (true) {
      emptyCount.acquire()
      buffer.plus(random.nextInt())
      fillCount.release()
    }
  }

  thread {
    while (true) {
      fillCount.acquire()
      val item = buffer.remove(0)
      println("Consumed item $item")
      emptyCount.release()
    }
  }
    }

fun semaphore2() {

  val emptyCount = Semaphore(8)
  val fillCount = Semaphore(0)
  val mutex = Semaphore(1)
  val buffer = mutableSetOf<Int>()

  thread {
    val random = Random()
    while (true) {
      emptyCount.acquire()
      mutex.acquire()
      buffer.plus(random.nextInt())
      mutex.release()
      fillCount.release()
    }
  }

  thread {
    while (true) {
      fillCount.acquire()
      mutex.acquire()
      val item = buffer.remove(0)
      mutex.release()
      println("Consumed item $item")
      emptyCount.release()
    }
  }
}