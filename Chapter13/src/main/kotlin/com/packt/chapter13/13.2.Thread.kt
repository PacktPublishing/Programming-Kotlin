package com.packt.chapter13

import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingDeque
import kotlin.concurrent.thread

fun immediateStart() {
  thread(start = true, name = "mythread") {
    while (true) {
      println("Hello, I am running on a thread")
    }
  }
}

fun delayedStart() {
  val t = thread(start = false, name = "mythread") {
    while (true) {
      println("Hello, I am running on a thread sometime later")
    }
  }
  t.start()
}

class StoppableTask : Runnable {

  @Volatile var running = true

  override fun run() {
    thread(start = true, name = "mythread") {
      while (running) {
        println("Hello, I am running on a thread until I am stopped")
      }
    }
  }
}

fun producerConsumer() {

  val queue = LinkedBlockingDeque<Int>()

  val consumerTasks = (1..6).map { ConsumerTask(queue) }
  val producerTask = ProducerTask(queue)

  val consumerThreads = consumerTasks.map { thread { it.run() } }
  val producerThread = thread { producerTask.run() }

  consumerTasks.forEach { it.running = false }
  producerTask.running = false
}

class ProducerTask(val queue: BlockingQueue<Int>) {

  @Volatile var running = true
  private val random = Random()

  fun run() {
    while (running) {
      Thread.sleep(1000)
      queue.put(random.nextInt())
    }
  }
}

class ConsumerTask(val queue: BlockingQueue<Int>) {

  @Volatile var running = true

  fun run() {
    while (running) {
      val element = queue.take()
      println("I am processing element $element")
    }
  }
}

fun interruptableProducerConsumer() {

  val queue = LinkedBlockingDeque<Int>()

  val consumerTasks = (1..6).map { InterruptableConsumerTask(queue) }
  val producerTask = ProducerTask(queue)

  val consumerThreads = consumerTasks.map { thread { it.run() } }
  val producerThread = thread { producerTask.run() }

  // later

  consumerThreads.forEach { it.interrupt() }
  producerTask.running = false
}

class InterruptableConsumerTask(val queue: BlockingQueue<Int>) : Runnable {

  override fun run() {
    try {
      while (!Thread.interrupted()) {
        val element = queue.take()
        println("I am processing element $element")
      }
    } catch (e: InterruptedException) {
      // shutting down
    }
  }
}
