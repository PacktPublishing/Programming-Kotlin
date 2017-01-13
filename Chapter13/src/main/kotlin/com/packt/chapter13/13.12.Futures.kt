package com.packt.chapter13

import java.util.concurrent.Callable
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.function.Supplier

fun futures() {

  val executor = Executors.newFixedThreadPool(4)

  val future: Future<Double> = executor.submit(
      Callable<Double> {
        Math.sqrt(15.64)
      }
  )
}

fun completableFuture() {
  val executor = Executors.newFixedThreadPool(4)
  val future = CompletableFuture.supplyAsync(Supplier { Math.sqrt(15.64) }, executor)
  future.thenApply {
    println("The square root has been calculated")
  }
}

fun completableFutureSequential(order: Order) {

  fun persistOrder(order: Order): String = TODO()
  fun chargeCard(card: Card): Boolean = TODO()
  fun printInvoice(order: Order): Unit = TODO()

  CompletableFuture.supplyAsync {
    persistOrder(order)
  }.thenApply { id ->
    println("Order has been saved; id is $id")
    chargeCard(order.card)
  }.thenApply { result ->
    if (result) {
      println("Order has been charged; printing invoice")
      printInvoice(order)
    }
  }
}

fun completableFutureParallel(order: Order) {

  fun persistOrder(order: Order): CompletableFuture<String> = TODO()
  fun chargeCard(card: Card): CompletableFuture<Boolean> = TODO()
  fun printInvoice(order: Order): CompletableFuture<Unit> = TODO()

  CompletableFuture.allOf(
      persistOrder(order),
      chargeCard(order.card),
      printInvoice(order)
  ).thenApply {
    println("Order is saved, charged and printed")
  }
}