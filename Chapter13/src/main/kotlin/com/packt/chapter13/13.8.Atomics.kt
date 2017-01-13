package com.packt.chapter13

import counter
import java.sql.Connection
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.atomic.AtomicReference
import kotlin.concurrent.thread

fun atomicCounters() {
  val counter = AtomicLong(0)
  (1..8).forEach {
    thread {
      while (true) {
        val id = counter.incrementAndGet()
        println("Creating item with id $id")
      }
    }
  }
}

fun openConnection(): Connection = TODO()

fun atomicReferences() {
  val ref = AtomicReference<Connection>()
  (1..8).forEach {
    thread {
      ref.compareAndSet(null, openConnection())
      val conn = ref.get()
    }
  }
}