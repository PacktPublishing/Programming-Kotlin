package com.packt.chapter13

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

fun syncExample() {

  val obj = Any()
  synchronized(obj) {

  }
}

fun lockOrNot() {
  val lock = ReentrantLock()
  if (lock.tryLock()) {
    println("I have the lock")
    lock.unlock()
  } else {
    println("I do not have the lock")
  }
}

fun lockOrInterrupt() {
  val lock = ReentrantLock()
  try {
    lock.lockInterruptibly()
    println("I have the lock")
    lock.unlock()
  } catch (e: InterruptedException) {
    println("I was interrupted")
  }
}

fun kotlinLock() {
  val lock = ReentrantLock()
  lock.withLock {
    println("I have the lock")
  }
}