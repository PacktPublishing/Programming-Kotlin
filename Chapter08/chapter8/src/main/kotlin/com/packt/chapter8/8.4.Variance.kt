package com.packt.chapter8

import java.util.*

open class Fruit {
  fun isSafeToEat(): Boolean = TODO()
}

class Apple : Fruit()
class Orange : Fruit()
class Tomato : Fruit()

class Crate<T>(val elements: MutableList<T>) {
  fun add(t: T) = elements.add(t)
  fun last(): T = elements.last()
}

class CovariantCrate<out T>(val elements: List<T>) {
  fun last(): T = elements.last()
}

fun isSafe(crate: CovariantCrate<Fruit>): Boolean = crate.elements.all { it.isSafeToEat() }

fun isSafeExample() {
  val oranges = CovariantCrate(listOf(Orange(), Orange()))
  isSafe(oranges)
}

open class Animal
class Sheep : Animal()

abstract class Farm {
  abstract fun get(): Animal
}

class SheepFarm() : Farm() {
  override fun get(): Sheep = Sheep()
}

fun farmExamples() {

  val farm: Farm = SheepFarm()
  val animal = farm.get()

  val sheepFarm = SheepFarm()
  val sheep: Sheep = sheepFarm.get() // is a Sheep
}

interface Listener<in T> {
  fun onNext(t: T): Unit
}

class EventStream<T>(val listener: Listener<T>) {
  fun start(): Unit = TODO()
  fun stop(): Unit = TODO()
}

fun usingStreams() {

  val stringListener = object : Listener<String> {
    override fun onNext(t: String) = println(t)
  }
  val stringStream = EventStream<String>(stringListener)
  stringStream.start()

  val dateListener = object : Listener<Date> {
    override fun onNext(t: Date) = println(t)
  }
  val dateStream = EventStream<Date>(dateListener)
  stringStream.start()

  val loggingListener = object : Listener<Any> {
    override fun onNext(t: Any) = println(t)
  }
  val doubleStream = EventStream<Double>(loggingListener)
  doubleStream.start()
}

interface Generator<T> {
  fun generate(): T
}

class OrangePicker(val generator: Generator<Orange>) {
  fun pick() {
    val orange = generator.generate()
    peel(orange)
  }

  fun peel(orange: Orange): Unit = TODO()
}