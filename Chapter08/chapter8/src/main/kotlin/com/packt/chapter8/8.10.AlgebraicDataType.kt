package com.packt.chapter8

sealed class LinkedList<out T> {

  fun isEmpty() = when (this) {
    is Empty -> true
    is Node -> false
  }

  fun size(): Int = when (this) {
    is Empty -> 0
    is Node -> 1 + this.next.size()
  }

  fun tail(): LinkedList<T> = when (this) {
    is Node -> this.next
    is Empty -> this
  }

  fun head(): T = when (this) {
    is Node<T> -> this.value
    is Empty -> throw RuntimeException("Empty list")
  }

  fun drop(k: Int): LinkedList<T> = when (this) {
    is Empty -> Empty
    is Node -> if (k <= 0) this else this.next.drop(k - 1)
  }

  operator fun get(pos: Int): T {
    require(pos >= 0, { "Position must be greater than or equal to zero" })
    return when (this) {
      is Node<T> -> if (pos == 0) head() else this.next.get(pos - 1)
      is Empty -> throw IndexOutOfBoundsException()
    }
  }

  fun append(t: @UnsafeVariance T): LinkedList<T> = when (this) {
    is Node<T> -> Node(this.value, this.next.append(t))
    is Empty -> Node(t, Empty)
  }

  companion object {
    operator fun <T> invoke(vararg values: T): LinkedList<T> {
      var temp: LinkedList<T> = Empty
      for (value in values) {
        temp = temp.append(value)
      }
      return temp
    }
  }
}

private class Node<out T>(val value: T, val next: LinkedList<T>) : LinkedList<T>()
private object Empty : LinkedList<Nothing>()

fun <T> LinkedList<T>.append(t: T): LinkedList<T> = when (this) {
  is Node<T> -> Node(this.value, this.next.append(t))
  is Empty -> Node(t, Empty)
}

fun main(args: Array<String>) {
  val list = LinkedList("this").append("is").append("my").append("list")
  println(list.size()) // prints 4
  println(list.head()) // prints "this"
  println(list[1]) // prints "is"
  println(list.drop(2).head()) // prints "my"
}