@file:JvmName("Chapter4")

package com.packt.chapter4

import java.io.File
import java.io.IOException

fun cube(n: Int): Int = n * n * n

@JvmOverloads fun join(array: Array<String>,
                       prefix: String = "",
                       separator: String = "",
                       suffix: String = ""): String {
  return ""
}

@Throws(IOException::class)
fun createDirectory(file: File) {
  if (file.exists())
    throw IOException("Directory already exists")
  file.createNewFile()
}

object Erasure {
  fun println(array: Array<String>): Unit {}
  fun println(array: Array<Long>) : Unit {}
}