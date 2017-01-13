package com.packt.chapter4

import java.util.*

abstract class DroppableArrayList<E> : ArrayList<E>() {
  fun drop(k: Int): List<E> {
    val resultSize = size - k
    when {
      resultSize <= 0 -> return emptyList<E>()
      else -> {
        val list = ArrayList<E>(resultSize)
        for (index in k..size - 1) {
          list.add(this[index])
        }
        return list
      }
    }
  }
}

fun <E> drop(k: Int, list: List<E>): List<E> {
  val resultSize = list.size - k
  when {
    resultSize <= 0 -> return emptyList<E>()
    else -> {
      val newList = ArrayList<E>(resultSize)
      for (index in k..list.size - 1) {
        newList.add(list[index])
      }
      return newList
    }
  }
}

fun <E> List<E>.drop2(k: Int): List<E> {
  val resultSize = size - k
  when {
    resultSize <= 0 -> return emptyList<E>()
    else -> {
      val list = ArrayList<E>(resultSize)
      for (index in k..size - 1) {
        list.add(this[index])
      }
      return list
    }
  }
}

fun Submarine.fire(): Unit {
  println("Fire on board!")
}

fun Submarine.submerge(depth: Int): Unit {
  println("Submerging to a depth of $depth fathoms")
}

class Submarine {

  fun fire(): Unit {
    println("Firing torpedoes")
  }

  fun submerge(): Unit {
    println("Submerging")
  }
}

object SubmarineUsage {
  init {
    val sub = Submarine()
    sub.submerge()
    sub.submerge(10)
  }
}

fun Any?.safeEquals(other: Any?): Boolean {
  if (this == null && other == null) return true
  if (this == null) return false
  return this.equals(other)
}

fun Int.Companion.random(): Int {
  val random = Random()
  return random.nextInt()
}

object UseRandom {
  val int = Int.random()
}

class Mappings {

  private val map = hashMapOf<Int, String>()

  private fun String.stringAdd(): Unit {
    map.put(hashCode(), this)
  }

  fun add(str: String): Unit = str.stringAdd()
}

class Mappings2 {

  private val map = hashMapOf<Int, String>()

  private fun String.stringAdd(): Unit {
    map.put(this@Mappings2.hashCode(), this)
  }

  fun add(str: String): Unit = str.stringAdd()
}

open class Particle

class Electron : Particle()

open class Element(val name: String) {

  open fun Particle.react(name: String): Unit {
    println("$name is reacting with a particle")
  }

  open fun Electron.react(name: String): Unit {
    println("$name is reacting with an electron")
  }

  fun react(particle: Particle): Unit {
    particle.react(name)
  }
}

class NobleGas(name: String) : Element(name) {

  override fun Particle.react(name: String): Unit {
    println("$name is noble, it doesn't react with particles")
  }

  override fun Electron.react(name: String): Unit {
    println("$name is noble, it doesn't react with electrons")
  }

  fun react(particle: Electron): Unit {
    particle.react(name)
  }
}

fun main(args: Array<String>) {

  val selenium = Element("Selenium")
  selenium.react(Particle())
  selenium.react(Electron())

  val neon = NobleGas("Neon")
  neon.react(Particle())
  neon.react(Electron())
}
