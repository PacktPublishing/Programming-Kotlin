package com.packt.chapter11

import io.kotlintest.Duration.Companion.seconds
import io.kotlintest.Eventually
import io.kotlintest.specs.ShouldSpec
import io.kotlintest.specs.WordSpec
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

fun createFile(file: String, onComplete: () -> Unit = {}): Unit {

}

fun createFileCallbackExample() {
  val latch = CountDownLatch(1)
  createFile("/home/davidcopperfield.txt", { latch.countDown() })
  latch.await(1, TimeUnit.MINUTES)
  // continue with test
}

fun createFileThreadSleepExample() {
  createFile("/home/davidcopperfield.txt")
  Thread.sleep(5000)
  // continue with test
}

class FileCreateWithEventually : ShouldSpec(), Eventually {

  init {
    should("create file") {
      eventually(60.seconds) {
        createFile("/home/davidcopperfield.txt")
      }
    }
  }
}