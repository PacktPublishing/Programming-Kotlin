package com.packt.chapter8

fun isSafe(crate: Crate<out Fruit>): Boolean = crate.elements.all { it.isSafeToEat() }

fun usingTypeProjection() {
  val oranges = Crate(mutableListOf(Orange(), Orange()))
  isSafe(oranges)
}

interface Listener2<T> {
  fun onNext(t: T): Unit
}

class EventStream2<T>(val listener: Listener2<in T>) {
  fun start(): Unit = TODO()
  fun stop(): Unit = TODO()
}