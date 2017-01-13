package com.packt.chapter2

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

class File(path: String) {
  fun close(): Unit {
  }
}

fun openFile(): File = File("")
fun readFromFile(file: File): Unit {
}

fun readFile(path: Path): Unit {
  val input = Files.newInputStream(path)
  try {
    var byte = input.read()
    while (byte != -1) {
      println(byte)
      byte = input.read()
    }
  } catch (e: IOException) {
    println("Error reading from file. Error was ${e.message}")
  } finally {
    input.close()
  }
}