package com.packt.chapter5

import java.nio.file.Files
import java.nio.file.Paths

inline fun <T : AutoCloseable, U> withResource(resource: T, fn: (T) -> U): U {
  try {
    return fn(resource)
  } finally {
    resource.close()
  }
}

fun characterCount(filename: String): Int {
  val input = Files.newInputStream(Paths.get(filename))
  return withResource(input) {
    input.buffered().reader().readText().length
  }
}

fun characterCountExpanded(filename: String): Int {
  val input = Files.newInputStream(Paths.get(filename))
  try {
    return input.buffered().reader().readText().length
  } finally {
    input.close()
  }
}

inline fun <T : AutoCloseable, U, V> withResource(resource: T, before: (T) -> U, noinline after: (U) -> V): V {
  val u = try {
    before(resource)
  } finally {
    resource.close()
  }
  return after(u)
}

fun characterCountInKilobytes(filename: String): Int {
  val input = Files.newInputStream(Paths.get(filename))
  return withResource(
      input,
      { input.buffered().reader().readText().length },
      { it * 1024 }
  )
}

fun characterCountInKilobytesExpanded(filename: String): Int {
  val input = Files.newInputStream(Paths.get(filename))
  val size = try {
    input.buffered().reader().readText().length
  } finally {
    input.close()
  }
  val fn: (Int) -> Int = { it * 1024 }
  return fn(size)
}